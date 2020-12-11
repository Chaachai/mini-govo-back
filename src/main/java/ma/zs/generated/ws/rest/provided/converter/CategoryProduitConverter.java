package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.CategoryProduit; 
import ma.zs.generated.ws.rest.provided.vo.CategoryProduitVo;

@Component 
public class CategoryProduitConverter extends AbstractConverter<CategoryProduit,CategoryProduitVo>{ 
	
	   @Autowired
         private SuperCategoryProductConverter superCategoryProductConverter ;
    private Boolean superCategoryProduct;

	public  CategoryProduitConverter(){
		init(true);
	}

	@Override 
 	public CategoryProduit toItem(CategoryProduitVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	CategoryProduit item = new CategoryProduit();
			 if(StringUtil.isNotEmpty(vo.getImagePath()))
                  item.setImagePath(vo.getImagePath());
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getSuperCategoryProductVo()!=null && this.superCategoryProduct)
			     item.setSuperCategoryProduct(superCategoryProductConverter.toItem(vo.getSuperCategoryProductVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public CategoryProduitVo toVo(CategoryProduit item) {
 		if (item == null) {
    		return null;
      	} else {
			CategoryProduitVo vo = new CategoryProduitVo();

			if(StringUtil.isNotEmpty(item.getImagePath()))
				vo.setImagePath(item.getImagePath());
			
			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getSuperCategoryProduct()!=null && this.superCategoryProduct) {
				   vo.setSuperCategoryProductVo(superCategoryProductConverter.toVo(item.getSuperCategoryProduct())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       superCategoryProduct = value;
	}


	

	
	   public SuperCategoryProductConverter getSuperCategoryProductConverter(){
		return this.superCategoryProductConverter;
	}  
        public void setSuperCategoryProductConverter(SuperCategoryProductConverter superCategoryProductConverter ){
		 this.superCategoryProductConverter = superCategoryProductConverter;
	}  
	
	 public boolean  isSuperCategoryProduct(){
		  return this.superCategoryProduct;
	 }
	 public void  setSuperCategoryProduct(boolean superCategoryProduct){
		   this.superCategoryProduct = superCategoryProduct;
	 }
}