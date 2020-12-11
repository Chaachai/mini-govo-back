package  ma.zs.generated.ws.rest.provided.vo;


public class RatingVo {

     private String comment ;
   
     private String mark ;
   
     private String id ;
   

	private UserVo clientVo ;
	private OrderLineVo orderLineVo ;
	private UserVo collaboratorVo ;


     private String markMax ;
     private String markMin ;

 public RatingVo(){
       super();
     }


     public String getComment(){
          return this.comment;
     }
      public void setComment(String comment){
          this.comment = comment;
     }


     public String getMark(){
          return this.mark;
     }
      public void setMark(String mark){
          this.mark = mark;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getMarkMax(){
          return this.markMax;
     }
     
      public String getMarkMin(){
          return this.markMin;
     }

     public void setMarkMax(String markMax){
          this.markMax = markMax;
     }

     public void setMarkMin(String markMin){
          this.markMin = markMin;
     }
     
     
     

      public UserVo getClientVo(){
          return this.clientVo;
     }
       
     public void setClientVo(UserVo clientVo){
          this.clientVo = clientVo;
     }
   
      public OrderLineVo getOrderLineVo(){
          return this.orderLineVo;
     }
       
     public void setOrderLineVo(OrderLineVo orderLineVo){
          this.orderLineVo = orderLineVo;
     }
   
      public UserVo getCollaboratorVo(){
          return this.collaboratorVo;
     }
       
     public void setCollaboratorVo(UserVo collaboratorVo){
          this.collaboratorVo = collaboratorVo;
     }
   




}