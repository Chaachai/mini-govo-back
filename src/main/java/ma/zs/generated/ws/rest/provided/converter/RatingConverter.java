package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Rating; 
import ma.zs.generated.ws.rest.provided.vo.RatingVo;

@Component 
public class RatingConverter extends AbstractConverter<Rating,RatingVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private OrderLineConverter orderLineConverter ;
    private Boolean client=false;
    private Boolean orderLine=false;
    private Boolean collaborator=false;

	public  RatingConverter(){
		init(true);
	}

	@Override 
 	public Rating toItem(RatingVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Rating item = new Rating();
			 if(StringUtil.isNotEmpty(vo.getComment()))
                  item.setComment(vo.getComment());
			 if(StringUtil.isNotEmpty(vo.getMark()))
                  item.setMark(NumberUtil.toLong(vo.getMark()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getClientVo()!=null && this.client)
			     item.setClient(userConverter.toItem(vo.getClientVo())) ;
             if(vo.getOrderLineVo()!=null && this.orderLine)
			     item.setOrderLine(orderLineConverter.toItem(vo.getOrderLineVo())) ;
             if(vo.getCollaboratorVo()!=null && this.collaborator)
			     item.setCollaborator(userConverter.toItem(vo.getCollaboratorVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public RatingVo toVo(Rating item) {
 		if (item == null) {
    		return null;
      	} else {
			RatingVo vo = new RatingVo();

			if(StringUtil.isNotEmpty(item.getComment()))
				vo.setComment(item.getComment());
			
			 if(item.getMark()!=null)
				vo.setMark(NumberUtil.toString(item.getMark()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getClient()!=null && this.client) {
				   vo.setClientVo(userConverter.toVo(item.getClient())) ;
			   } 
            if(item.getOrderLine()!=null && this.orderLine) {
				   vo.setOrderLineVo(orderLineConverter.toVo(item.getOrderLine())) ;
			   } 
            if(item.getCollaborator()!=null && collaborator) {
				   vo.setCollaboratorVo(userConverter.toVo(item.getCollaborator())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       client = value;
       orderLine = value;
       collaborator = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public OrderLineConverter getOrderLineConverter(){
		return this.orderLineConverter;
	}  
        public void setOrderLineConverter(OrderLineConverter orderLineConverter ){
		 this.orderLineConverter = orderLineConverter;
	}  
	
	 public boolean  isClient(){
		  return this.client;
	 }
	 public void  setClient(boolean client){
		   this.client = client;
	 }
	 public boolean  isOrderLine(){
		  return this.orderLine;
	 }
	 public void  setOrderLine(boolean orderLine){
		   this.orderLine = orderLine;
	 }
	 public boolean  isCollaborator(){
		  return this.collaborator;
	 }
	 public void  setCollaborator(boolean collaborator){
		   this.collaborator = collaborator;
	 }
}