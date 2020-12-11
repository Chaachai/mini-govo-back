package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.bean.MesureUnit;

@Entity
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String label  ;
     private BigDecimal price ;
     private String imagePath ;
     private String reference ;

     @ManyToOne
	private CategoryProduit categoryProduit ;
     @ManyToOne
	private MesureUnit mesureUnit ;

     public Product(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public BigDecimal getPrice(){
          return this.price;
     }
     public void setPrice(BigDecimal price){
          this.price = price;
     }
     public String getReference(){
          return this.reference;
     }
     public void setReference(String reference){
          this.reference = reference;
     }
     public String getLabel (){
          return this.label ;
     }
     public void setLabel (String label ){
          this.label  = label ;
     }
     public CategoryProduit getCategoryProduit(){
          return this.categoryProduit;
     }
     public void setCategoryProduit(CategoryProduit categoryProduit){
          this.categoryProduit = categoryProduit;
     }
     public String getImagePath(){
          return this.imagePath;
     }
     public void setImagePath(String imagePath){
          this.imagePath = imagePath;
     }
     public MesureUnit getMesureUnit(){
          return this.mesureUnit;
     }
     public void setMesureUnit(MesureUnit mesureUnit){
          this.mesureUnit = mesureUnit;
     }



}

