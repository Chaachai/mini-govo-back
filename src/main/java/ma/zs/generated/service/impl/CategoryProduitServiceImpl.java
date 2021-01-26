package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.bean.SuperCategoryProduct;
import ma.zs.generated.dao.CategoryProduitDao;
import ma.zs.generated.service.facade.CategoryProduitService;
import ma.zs.generated.service.facade.SuperCategoryProductService;   

import ma.zs.generated.ws.rest.provided.vo.CategoryProduitVo;
import ma.zs.generated.service.util.*;
@Service
public class CategoryProduitServiceImpl implements CategoryProduitService {

   @Autowired
   private CategoryProduitDao categoryProduitDao;
   
    @Autowired
    private SuperCategoryProductService superCategoryProductService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<CategoryProduit> findAll(){
		return categoryProduitDao.findAll();
	}	
	@Override
	public List<CategoryProduit> findBySuperCategoryProductLabel(String label){
		return categoryProduitDao.findBySuperCategoryProductLabel(label);
	}
	@Override
	@Transactional
    public int deleteBySuperCategoryProductLabel(String label){
		return categoryProduitDao.deleteBySuperCategoryProductLabel(label);
	}
	
     @Override
    public List<CategoryProduit> findBySuperCategoryProductId(Long id){
		return categoryProduitDao.findBySuperCategoryProductId(id);

	}
	   @Override
	   @Transactional
    public int deleteBySuperCategoryProductId(Long id){
		return categoryProduitDao.deleteBySuperCategoryProductId(id);

	}
     		
	@Override
	public CategoryProduit findByLabel(String label){
		if( label==null)
		  return null;
		return categoryProduitDao.findByLabel(label);
	}

   

	@Override
	@Transactional
	public int deleteByLabel(String  label) {
		return categoryProduitDao.deleteByLabel(label);	 
	}

	@Override
	public CategoryProduit findById(Long id){
		 if(id==null)
		  return null;
		return categoryProduitDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           categoryProduitDao.deleteById(id);
   }
	@Override	
	public CategoryProduit save (CategoryProduit categoryProduit){
			CategoryProduit foundedCategoryProduit = findByLabel(categoryProduit.getLabel());
	       if(foundedCategoryProduit!=null)
	          return null;  
	    
	          if(categoryProduit.getSuperCategoryProduct()!=null){
				    SuperCategoryProduct superCategoryProduct = superCategoryProductService.findByLabel(categoryProduit.getSuperCategoryProduct().getLabel());
				  if(superCategoryProduct == null)
				  categoryProduit.setSuperCategoryProduct(superCategoryProductService.save(categoryProduit.getSuperCategoryProduct()));
				  else
				  categoryProduit.setSuperCategoryProduct(superCategoryProduct);
			  }
		String filePath=ImageUtil.storeImage("./src/main/resources/images/categoryproduits/",categoryProduit.getLabel(),categoryProduit.getImagePath());
		categoryProduit.setImagePath(filePath);

	    CategoryProduit savedCategoryProduit = categoryProduitDao.save(categoryProduit);
	   return savedCategoryProduit;
	}

    @Override
    public List<CategoryProduit> save(List<CategoryProduit> categoryProduits){
		List<CategoryProduit> list = new ArrayList<CategoryProduit>();
		for(CategoryProduit categoryProduit: categoryProduits){
		        list.add(save(categoryProduit));	
		}
		return list;
	}


   @Override
   public CategoryProduit update(CategoryProduit categoryProduit){
     
    
		  CategoryProduit foundedCategoryProduit = findById(categoryProduit.getId()); 
		       if(foundedCategoryProduit==null)
	          return null;	  
	  
	   return  categoryProduitDao.save(categoryProduit);
     
     }
    
	@Override
	@Transactional
	public int delete(CategoryProduit categoryProduit){

	        if(categoryProduit.getLabel()==null)
			  return -1;
		
			CategoryProduit foundedCategoryProduit = findByLabel(categoryProduit.getLabel());
	       if(foundedCategoryProduit==null)
	          return -1;  
	   categoryProduitDao.delete(foundedCategoryProduit);
	   return 1;
	}


	public List<CategoryProduit> findByCriteria(CategoryProduitVo categoryProduitVo){
      String query = "SELECT o FROM CategoryProduit o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "imagePath","LIKE",categoryProduitVo.getImagePath());

			 query += SearchUtil.addConstraint( "o", "label","LIKE",categoryProduitVo.getLabel());

		 	 query += SearchUtil.addConstraint( "o", "id","=",categoryProduitVo.getId());
   if(categoryProduitVo.getSuperCategoryProductVo()!=null){
     query += SearchUtil.addConstraint( "o", "superCategoryProduct.id","=",categoryProduitVo.getSuperCategoryProductVo().getId());
     query += SearchUtil.addConstraint( "o", "superCategoryProduct.label","LIKE",categoryProduitVo.getSuperCategoryProductVo().getLabel());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
