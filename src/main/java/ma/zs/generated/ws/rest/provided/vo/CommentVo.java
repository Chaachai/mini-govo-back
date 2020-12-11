package  ma.zs.generated.ws.rest.provided.vo;

import java.util.Date;

public class CommentVo {

     private String commentDate ;
   
     private String message ;
   
     private String id ;
   

	private UserVo userVo ;
	private CommandVo commandVo ;


     private String commentDateMax ;
     private String commentDateMin ;

 public CommentVo(){
       super();
     }


     public String getCommentDate(){
          return this.commentDate;
     }
      public void setCommentDate(String commentDate){
          this.commentDate = commentDate;
     }


     public String getMessage(){
          return this.message;
     }
      public void setMessage(String message){
          this.message = message;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getCommentDateMax(){
          return this.commentDateMax;
     }
     
      public String getCommentDateMin(){
          return this.commentDateMin;
     }

     public void setCommentDateMax(String commentDateMax){
          this.commentDateMax = commentDateMax;
     }

     public void setCommentDateMin(String commentDateMin){
          this.commentDateMin = commentDateMin;
     }
     
     
     

      public UserVo getUserVo(){
          return this.userVo;
     }
       
     public void setUserVo(UserVo userVo){
          this.userVo = userVo;
     }
   
      public CommandVo getCommandVo(){
          return this.commandVo;
     }
       
     public void setCommandVo(CommandVo commandVo){
          this.commandVo = commandVo;
     }
   




}