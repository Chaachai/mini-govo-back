package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class SuperCategoryProduct {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String description ;
     private String imagePath ;
     private String label ;


     public SuperCategoryProduct(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getLabel(){
          return this.label;
     }
     public void setLabel(String label){
          this.label = label;
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



}

