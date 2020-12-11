package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Command;

@Entity
public class Comment {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date commentDate ;
     private String message ;

     @ManyToOne
	private User user ;
     @ManyToOne
	private Command command ;

     public Comment(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getMessage(){
          return this.message;
     }
     public void setMessage(String message){
          this.message = message;
     }
     public Date getCommentDate(){
          return this.commentDate;
     }
     public void setCommentDate(Date commentDate){
          this.commentDate = commentDate;
     }
     public Command getCommand(){
          return this.command;
     }
     public void setCommand(Command command){
          this.command = command;
     }
     public User getUser(){
          return this.user;
     }
     public void setUser(User user){
          this.user = user;
     }



}

