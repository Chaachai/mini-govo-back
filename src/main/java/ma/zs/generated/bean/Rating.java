package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.User;

@Entity
public class Rating {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String comment ;
     private Long mark ;

     @ManyToOne
	private User client ;
     @ManyToOne
	private OrderLine orderLine ;
     @ManyToOne
	private User collaborator ;

     public Rating(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public OrderLine getOrderLine(){
          return this.orderLine;
     }
     public void setOrderLine(OrderLine orderLine){
          this.orderLine = orderLine;
     }
     public User getCollaborator(){
          return this.collaborator;
     }
     public void setCollaborator(User collaborator){
          this.collaborator = collaborator;
     }
     public User getClient(){
          return this.client;
     }
     public void setClient(User client){
          this.client = client;
     }
     public Long getMark(){
          return this.mark;
     }
     public void setMark(Long mark){
          this.mark = mark;
     }
     public String getComment(){
          return this.comment;
     }
     public void setComment(String comment){
          this.comment = comment;
     }



}

