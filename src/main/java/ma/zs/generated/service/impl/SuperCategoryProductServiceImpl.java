package ma.zs.generated.service.impl;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import ma.zs.generated.bean.SuperCategoryProduct;
import ma.zs.generated.dao.SuperCategoryProductDao;
import ma.zs.generated.service.facade.SuperCategoryProductService;

import ma.zs.generated.ws.rest.provided.vo.SuperCategoryProductVo;
import ma.zs.generated.service.util.*;

@Service
public class SuperCategoryProductServiceImpl implements SuperCategoryProductService {

    @Autowired
    private SuperCategoryProductDao superCategoryProductDao;


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SuperCategoryProduct> findAll() {
        return superCategoryProductDao.findAll();
    }

    @Override
    public SuperCategoryProduct findByLabel(String label) {
        if (label == null)
            return null;
        return superCategoryProductDao.findByLabel(label);
    }


    @Override
    @Transactional
    public int deleteByLabel(String label) {
        return superCategoryProductDao.deleteByLabel(label);
    }

    @Override
    public SuperCategoryProduct findById(Long id) {
        if (id == null)
            return null;
        return superCategoryProductDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        superCategoryProductDao.deleteById(id);
    }

    @Override
    public SuperCategoryProduct save(SuperCategoryProduct superCategoryProduct) {
        SuperCategoryProduct foundedSuperCategoryProduct = findByLabel(superCategoryProduct.getLabel());
        if (foundedSuperCategoryProduct != null)
            return null;

        String filePath=ImageUtil.storeImage("./src/main/resources/images/supercategories/",superCategoryProduct.getLabel(),superCategoryProduct.getImagePath());
        superCategoryProduct.setImagePath(filePath);
        SuperCategoryProduct savedSuperCategoryProduct = superCategoryProductDao.save(superCategoryProduct);
        return savedSuperCategoryProduct;
    }

    @Override
    public List<SuperCategoryProduct> save(List<SuperCategoryProduct> superCategoryProducts) {
        List<SuperCategoryProduct> list = new ArrayList<SuperCategoryProduct>();
        for (SuperCategoryProduct superCategoryProduct : superCategoryProducts) {
            list.add(save(superCategoryProduct));
        }
        return list;
    }


    @Override
    public SuperCategoryProduct update(SuperCategoryProduct superCategoryProduct) {


        SuperCategoryProduct foundedSuperCategoryProduct = findById(superCategoryProduct.getId());
        if (foundedSuperCategoryProduct == null)
            return null;

        return superCategoryProductDao.save(superCategoryProduct);

    }

    @Override
    @Transactional
    public int delete(SuperCategoryProduct superCategoryProduct) {

        if (superCategoryProduct.getLabel() == null)
            return -1;

        SuperCategoryProduct foundedSuperCategoryProduct = findByLabel(superCategoryProduct.getLabel());
        if (foundedSuperCategoryProduct == null)
            return -1;
        superCategoryProductDao.delete(foundedSuperCategoryProduct);
        return 1;
    }


    public List<SuperCategoryProduct> findByCriteria(SuperCategoryProductVo superCategoryProductVo) {
        String query = "SELECT o FROM SuperCategoryProduct o where 1=1 ";
        query += SearchUtil.addConstraint("o", "description", "LIKE", superCategoryProductVo.getDescription());

        query += SearchUtil.addConstraint("o", "imagePath", "LIKE", superCategoryProductVo.getImagePath());

        query += SearchUtil.addConstraint("o", "label", "LIKE", superCategoryProductVo.getLabel());

        query += SearchUtil.addConstraint("o", "id", "=", superCategoryProductVo.getId());
        return entityManager.createQuery(query).getResultList();
    }


}
