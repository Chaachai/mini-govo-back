package  ma.zs.generated.ws.rest.provided.vo;


public class CategoryProduitVo {

     private String imagePath ;
   
     private String label ;
   
     private String id ;
   

	private SuperCategoryProductVo superCategoryProductVo ;



 public CategoryProduitVo(){
       super();
     }


     public String getImagePath(){
          return this.imagePath;
     }
      public void setImagePath(String imagePath){
          this.imagePath = imagePath;
     }


     public String getLabel(){
          return this.label;
     }
      public void setLabel(String label){
          this.label = label;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     

      public SuperCategoryProductVo getSuperCategoryProductVo(){
          return this.superCategoryProductVo;
     }
       
     public void setSuperCategoryProductVo(SuperCategoryProductVo superCategoryProductVo){
          this.superCategoryProductVo = superCategoryProductVo;
     }

    @Override
    public String toString() {
        return "CategoryProduitVo{" +
                "imagePath='" + imagePath + '\'' +
                ", label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", superCategoryProductVo=" + superCategoryProductVo +
                '}';
    }
}