package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Product; 
import ma.zs.generated.ws.rest.provided.vo.ProductVo;

@Component 
public class ProductConverter extends AbstractConverter<Product,ProductVo>{ 
	
	   @Autowired
         private MesureUnitConverter mesureUnitConverter ;
	   @Autowired
         private CategoryProduitConverter categoryProduitConverter ;
    private Boolean categoryProduit;
    private Boolean mesureUnit;

	public  ProductConverter(){
		init(true);
	}

	@Override 
 	public Product toItem(ProductVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Product item = new Product();
			 if(StringUtil.isNotEmpty(vo.getLabel ()))
                  item.setLabel (vo.getLabel ());
			 if(StringUtil.isNotEmpty(vo.getPrice()))
                  item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
			 if(StringUtil.isNotEmpty(vo.getImagePath()))
                  item.setImagePath(vo.getImagePath());
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCategoryProduitVo()!=null && this.categoryProduit)
			     item.setCategoryProduit(categoryProduitConverter.toItem(vo.getCategoryProduitVo())) ;
             if(vo.getMesureUnitVo()!=null && this.mesureUnit)
			     item.setMesureUnit(mesureUnitConverter.toItem(vo.getMesureUnitVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public ProductVo toVo(Product item) {
 		if (item == null) {
    		return null;
      	} else {
			ProductVo vo = new ProductVo();

			if(StringUtil.isNotEmpty(item.getLabel ()))
				vo.setLabel (item.getLabel ());
			
			 if(item.getPrice()!=null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
			if(StringUtil.isNotEmpty(item.getImagePath()))
				vo.setImagePath(item.getImagePath());
			
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCategoryProduit()!=null && this.categoryProduit) {
				   vo.setCategoryProduitVo(categoryProduitConverter.toVo(item.getCategoryProduit())) ;
			   } 
            if(item.getMesureUnit()!=null && this.mesureUnit) {
				   vo.setMesureUnitVo(mesureUnitConverter.toVo(item.getMesureUnit())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       categoryProduit = value;
       mesureUnit = value;
	}


	

	
	   public MesureUnitConverter getMesureUnitConverter(){
		return this.mesureUnitConverter;
	}  
        public void setMesureUnitConverter(MesureUnitConverter mesureUnitConverter ){
		 this.mesureUnitConverter = mesureUnitConverter;
	}  
	   public CategoryProduitConverter getCategoryProduitConverter(){
		return this.categoryProduitConverter;
	}  
        public void setCategoryProduitConverter(CategoryProduitConverter categoryProduitConverter ){
		 this.categoryProduitConverter = categoryProduitConverter;
	}  
	
	 public boolean  isCategoryProduit(){
		  return this.categoryProduit;
	 }
	 public void  setCategoryProduit(boolean categoryProduit){
		   this.categoryProduit = categoryProduit;
	 }
	 public boolean  isMesureUnit(){
		  return this.mesureUnit;
	 }
	 public void  setMesureUnit(boolean mesureUnit){
		   this.mesureUnit = mesureUnit;
	 }
}