package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class PricingCollaborator {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal priceMax ;
     private BigDecimal price ;
     private BigDecimal priceMin ;


     public PricingCollaborator(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public BigDecimal getPriceMin(){
          return this.priceMin;
     }
     public void setPriceMin(BigDecimal priceMin){
          this.priceMin = priceMin;
     }
     public BigDecimal getPriceMax(){
          return this.priceMax;
     }
     public void setPriceMax(BigDecimal priceMax){
          this.priceMax = priceMax;
     }
     public BigDecimal getPrice(){
          return this.price;
     }
     public void setPrice(BigDecimal price){
          this.price = price;
     }



}

