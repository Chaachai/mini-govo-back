package  ma.zs.generated.ws.rest.provided.vo;


public class SuperCategoryProductVo {

     private String description ;
   
     private String imagePath ;
   
     private String label ;
   
     private String id ;
   




 public SuperCategoryProductVo(){
       super();
     }


     public String getDescription(){
          return this.description;
     }
      public void setDescription(String description){
          this.description = description;
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

    @Override
    public String toString() {
        return "SuperCategoryProductVo{" +
                "description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", label='" + label + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}