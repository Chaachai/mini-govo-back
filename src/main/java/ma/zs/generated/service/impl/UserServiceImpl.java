package ma.zs.generated.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import ma.zs.generated.bean.PricingCollaborator;
import ma.zs.generated.bean.Product;
import ma.zs.generated.service.facade.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import ma.zs.generated.bean.User;
import ma.zs.generated.dao.UserDao;
import ma.zs.generated.service.facade.UserService;

import ma.zs.generated.ws.rest.provided.vo.UserVo;
import ma.zs.generated.service.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductService productService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        if (id == null)
            return null;
        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User save(User user) {
        if (user == null) {
            return null;
        } else if (StringUtil.isEmpty(user.getEmail())) {
            return null;
        } else if (userDao.findByEmail(user.getEmail()) != null) {
            return null;
        } else if (user.getPassword() == null) {
            return null;
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            User savedUser = userDao.save(user);
            return savedUser;
        }
    }

    @Override
    public List<User> save(List<User> users) {
        List<User> list = new ArrayList<User>();
        for (User user : users) {
            list.add(save(user));
        }
        return list;
    }


    @Override
    public User update(User user) {


        User foundedUser = findById(user.getId());
        if (foundedUser == null)
            return null;

        return userDao.save(user);

    }

    @Override
    @Transactional
    public int delete(User user) {

        if (user.getId() == null)
            return -1;
        User foundedUser = findById(user.getId());
        if (foundedUser == null)
            return -1;
        userDao.delete(foundedUser);
        return 1;
    }


    public List<User> findByCriteria(UserVo userVo) {
        String query = "SELECT o FROM User o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", userVo.getId());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByEmail(s);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getAuthority().getAuthority()));
        org.springframework.security.core.userdetails.User userDetailsUser = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        return userDetailsUser;
    }

    public List<User> findByCategoryProduitId(Long id) {
        if (id != null) return userDao.findByCategoryProduitId(id);
        else return null;
    }

    //collaborator having speciality on the category oof a product
    public List<User> findByProductId(Long id) {
        Product product = productService.findById(id);
        System.out.println("prod="+product);
        if (product != null && product.getCategoryProduit() != null) {
            List<User> users=findByCategoryProduitId(product.getCategoryProduit().getId());
            for (User u:users) {
                List<PricingCollaborator> pricingCollaborators=u.getPricingCollaborators();
                List<PricingCollaborator> newPricingCollaborators=new ArrayList<>();
                for (PricingCollaborator p:pricingCollaborators) {
                    System.out.println("2:"+p.getProduct().getId());
                    if (p.getProduct().getId()==id){
                        newPricingCollaborators.add(p);
                        break;
                    }
                }
                u.setPricingCollaborators(newPricingCollaborators);
            }
            return users;
        } else return null;
    }
}
