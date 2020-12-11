package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.SuperCategoryProduct;

@Entity
public class CategoryProduit {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String imagePath ;
     private String label ;

     @ManyToOne
	private SuperCategoryProduct superCategoryProduct ;

     public CategoryProduit(){
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
     public String getImagePath(){
          return this.imagePath;
     }
     public void setImagePath(String imagePath){
          this.imagePath = imagePath;
     }
     public SuperCategoryProduct getSuperCategoryProduct(){
          return this.superCategoryProduct;
     }
     public void setSuperCategoryProduct(SuperCategoryProduct superCategoryProduct){
          this.superCategoryProduct = superCategoryProduct;
     }



}

