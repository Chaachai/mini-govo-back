package  ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;   

public class ProductVo {

     private String label  ;
   
     private String price ;
   
     private String imagePath ;
   
     private String reference ;
   
     private String id ;
   

	private CategoryProduitVo categoryProduitVo ;
	private MesureUnitVo mesureUnitVo ;


     private String priceMax ;
     private String priceMin ;

 public ProductVo(){
       super();
     }


     public String getLabel (){
          return this.label ;
     }
      public void setLabel (String label ){
          this.label  = label ;
     }


     public String getPrice(){
          return this.price;
     }
      public void setPrice(String price){
          this.price = price;
     }


     public String getImagePath(){
          return this.imagePath;
     }
      public void setImagePath(String imagePath){
          this.imagePath = imagePath;
     }


     public String getReference(){
          return this.reference;
     }
      public void setReference(String reference){
          this.reference = reference;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getPriceMax(){
          return this.priceMax;
     }
     
      public String getPriceMin(){
          return this.priceMin;
     }

     public void setPriceMax(String priceMax){
          this.priceMax = priceMax;
     }

     public void setPriceMin(String priceMin){
          this.priceMin = priceMin;
     }
     
     
     

      public CategoryProduitVo getCategoryProduitVo(){
          return this.categoryProduitVo;
     }
       
     public void setCategoryProduitVo(CategoryProduitVo categoryProduitVo){
          this.categoryProduitVo = categoryProduitVo;
     }
   
      public MesureUnitVo getMesureUnitVo(){
          return this.mesureUnitVo;
     }
       
     public void setMesureUnitVo(MesureUnitVo mesureUnitVo){
          this.mesureUnitVo = mesureUnitVo;
     }
   




}