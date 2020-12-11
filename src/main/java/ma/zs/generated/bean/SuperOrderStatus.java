package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class SuperOrderStatus {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String color ;
     private String label ;
     private String code ;


     public SuperOrderStatus(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getCode(){
          return this.code;
     }
     public void setCode(String code){
          this.code = code;
     }
     public String getColor(){
          return this.color;
     }
     public void setColor(String color){
          this.color = color;
     }
     public String getLabel(){
          return this.label;
     }
     public void setLabel(String label){
          this.label = label;
     }



}

