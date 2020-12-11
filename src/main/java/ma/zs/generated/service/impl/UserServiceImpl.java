package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
   private EntityManager entityManager; 

	@Override
	public List<User> findAll(){
		return userDao.findAll();
	}	

	@Override
	public User findById(Long id){
		 if(id==null)
		  return null;
		return userDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           userDao.deleteById(id);
   }
	@Override	
	public User save (User user){

	    User savedUser = userDao.save(user);
	   return savedUser;
	}

    @Override
    public List<User> save(List<User> users){
		List<User> list = new ArrayList<User>();
		for(User user: users){
		        list.add(save(user));	
		}
		return list;
	}


   @Override
   public User update(User user){
     
    
		  User foundedUser = findById(user.getId()); 
		       if(foundedUser==null)
	          return null;	  
	  
	   return  userDao.save(user);
     
     }
    
	@Override
	@Transactional
	public int delete(User user){

		 if(user.getId()==null)
			  return -1;
		  User foundedUser = findById(user.getId()); 
		       if(foundedUser==null)
	          return -1;	  
	   userDao.delete(foundedUser);
	   return 1;
	}


	public List<User> findByCriteria(UserVo userVo){
      String query = "SELECT o FROM User o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "id","=",userVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
