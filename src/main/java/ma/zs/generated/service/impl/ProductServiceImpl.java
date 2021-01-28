package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.bean.MesureUnit;
import ma.zs.generated.dao.ProductDao;
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.service.facade.MesureUnitService;
import ma.zs.generated.service.facade.CategoryProduitService;

import ma.zs.generated.ws.rest.provided.vo.ProductVo;
import ma.zs.generated.service.util.*;
@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
   private ProductDao productDao;

    @Autowired
    private MesureUnitService mesureUnitService ;
    @Autowired
    private CategoryProduitService categoryProduitService ;

   @Autowired
   private EntityManager entityManager;

	@Override
	public List<Product> findAll(){
		return productDao.findAll();
	}
	@Override
	public List<Product> findByCategoryProduitLabel(String label){
		return productDao.findByCategoryProduitLabel(label);
	}
	@Override
	@Transactional
    public int deleteByCategoryProduitLabel(String label){
		return productDao.deleteByCategoryProduitLabel(label);
	}

     @Override
    public List<Product> findByCategoryProduitId(Long id){
		return productDao.findByCategoryProduitId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCategoryProduitId(Long id){
		return productDao.deleteByCategoryProduitId(id);

	}

	@Override
	public List<Product> findByMesureUnitLabel(String label){
		return productDao.findByMesureUnitLabel(label);
	}
	@Override
	@Transactional
    public int deleteByMesureUnitLabel(String label){
		return productDao.deleteByMesureUnitLabel(label);
	}

     @Override
    public List<Product> findByMesureUnitId(Long id){
		return productDao.findByMesureUnitId(id);

	}
	   @Override
	   @Transactional
    public int deleteByMesureUnitId(Long id){
		return productDao.deleteByMesureUnitId(id);

	}

	@Override
	public Product findByReference(String reference){
		if( reference==null)
		  return null;
		return productDao.findByReference(reference);
	}



	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return productDao.deleteByReference(reference);
	}

	@Override
	public Product findById(Long id){
		 if(id==null)
		  return null;
		return productDao.getOne(id);
	}

	@Transactional
   public void deleteById(Long id){
           productDao.deleteById(id);
   }
	@Override
	public Product save (Product product){
			Product foundedProduct = findByReference(product.getReference());
	       if(foundedProduct!=null)
	          return null;

	          if(product.getCategoryProduit()!=null){
				    CategoryProduit categoryProduit = categoryProduitService.findByLabel(product.getCategoryProduit().getLabel());
				  if(categoryProduit == null)
				  product.setCategoryProduit(categoryProduitService.save(product.getCategoryProduit()));
				  else
				  product.setCategoryProduit(categoryProduit);
			  }

	          if(product.getMesureUnit()!=null){
				    MesureUnit mesureUnit = mesureUnitService.findByLabel(product.getMesureUnit().getLabel());
				  if(mesureUnit == null)
				  product.setMesureUnit(mesureUnitService.save(product.getMesureUnit()));
				  else
				  product.setMesureUnit(mesureUnit);
			  }
        String filePath=ImageUtil.storeImage("./src/main/resources/images/products/",product.getLabel(),product.getImagePath());
        product.setImagePath(filePath);

	    Product savedProduct = productDao.save(product);
	   return savedProduct;
	}

    @Override
    public List<Product> save(List<Product> products){
		List<Product> list = new ArrayList<Product>();
		for(Product product: products){
		        list.add(save(product));
		}
		return list;
	}


   @Override
   public Product update(Product product){


		  Product foundedProduct = findById(product.getId());
		       if(foundedProduct==null)
	          return null;

	   return  productDao.save(product);

     }

	@Override
	@Transactional
	public int delete(Product product){

	        if(product.getReference()==null)
			  return -1;

			Product foundedProduct = findByReference(product.getReference());
	       if(foundedProduct==null)
	          return -1;
	   productDao.delete(foundedProduct);
	   return 1;
	}


	public List<Product> findByCriteria(ProductVo productVo){
      String query = "SELECT o FROM Product o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "label ","LIKE",productVo.getLabel ());

		 	 query += SearchUtil.addConstraint( "o", "price","=",productVo.getPrice());
			 query += SearchUtil.addConstraint( "o", "imagePath","LIKE",productVo.getImagePath());

			 query += SearchUtil.addConstraint( "o", "reference","LIKE",productVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "id","=",productVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","price",productVo.getPriceMin(),productVo.getPriceMax());
   if(productVo.getCategoryProduitVo()!=null){
     query += SearchUtil.addConstraint( "o", "categoryProduit.id","=",productVo.getCategoryProduitVo().getId());
     query += SearchUtil.addConstraint( "o", "categoryProduit.label","LIKE",productVo.getCategoryProduitVo().getLabel());
   }

   if(productVo.getMesureUnitVo()!=null){
     query += SearchUtil.addConstraint( "o", "mesureUnit.id","=",productVo.getMesureUnitVo().getId());
     query += SearchUtil.addConstraint( "o", "mesureUnit.label","LIKE",productVo.getMesureUnitVo().getLabel());
   }

	 return entityManager.createQuery(query).getResultList();
	}


}
