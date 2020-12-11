package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Command; 
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

@Component 
public class CommandConverter extends AbstractConverter<Command,CommandVo>{ 
	
	   @Autowired
         private CommentConverter commentConverter ;
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private OrderLineConverter orderLineConverter ;
	   @Autowired
         private CityConverter cityConverter ;
	   @Autowired
         private OrderStatusConverter orderStatusConverter ;
    private Boolean admin;
    private Boolean deliveryMan;
    private Boolean client;
    private Boolean city;
    private Boolean orderStatus;
    private Boolean orderLines;
    private Boolean comments;

	public  CommandConverter(){
		init(true);
	}

	@Override 
 	public Command toItem(CommandVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Command item = new Command();
			 if(StringUtil.isNotEmpty(vo.getCommentResolution()))
                  item.setCommentResolution(NumberUtil.toBoolean(vo.getCommentResolution()));
             if(StringUtil.isNotEmpty(vo.getRegulationDate()))
			      item.setRegulationDate(DateUtil.parse(vo.getRegulationDate()));
			 if(StringUtil.isNotEmpty(vo.getLongitudeDelivery()))
                  item.setLongitudeDelivery(NumberUtil.toBigDecimal(vo.getLongitudeDelivery()));
             if(StringUtil.isNotEmpty(vo.getCommentResolutionDate ()))
			      item.setCommentResolutionDate (DateUtil.parse(vo.getCommentResolutionDate ()));
             if(StringUtil.isNotEmpty(vo.getDateSubmission()))
			      item.setDateSubmission(DateUtil.parse(vo.getDateSubmission()));
			 if(StringUtil.isNotEmpty(vo.getNbrTotalComment()))
                  item.setNbrTotalComment(NumberUtil.toLong(vo.getNbrTotalComment()));
			 if(StringUtil.isNotEmpty(vo.getYearCommand()))
                  item.setYearCommand(NumberUtil.toLong(vo.getYearCommand()));
			 if(StringUtil.isNotEmpty(vo.getLatitudeDelivery()))
                  item.setLatitudeDelivery(NumberUtil.toBigDecimal(vo.getLatitudeDelivery()));
             if(StringUtil.isNotEmpty(vo.getOrderDate()))
			      item.setOrderDate(DateUtil.parse(vo.getOrderDate()));
			 if(StringUtil.isNotEmpty(vo.getAddress()))
                  item.setAddress(vo.getAddress());
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getDayCommand()))
                  item.setDayCommand(NumberUtil.toLong(vo.getDayCommand()));
			 if(StringUtil.isNotEmpty(vo.getMonthCommand()))
                  item.setMonthCommand(NumberUtil.toLong(vo.getMonthCommand()));
			 if(StringUtil.isNotEmpty(vo.getRemark()))
                  item.setRemark(vo.getRemark());
			 if(StringUtil.isNotEmpty(vo.getTotal()))
                  item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
             if(vo.getAdminVo()!=null && this.admin)
			     item.setAdmin(userConverter.toItem(vo.getAdminVo())) ;
             if(vo.getDeliveryManVo()!=null && this.deliveryMan)
			     item.setDeliveryMan(userConverter.toItem(vo.getDeliveryManVo())) ;
             if(vo.getClientVo()!=null && this.client)
			     item.setClient(userConverter.toItem(vo.getClientVo())) ;
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;
             if(vo.getOrderStatusVo()!=null && this.orderStatus)
			     item.setOrderStatus(orderStatusConverter.toItem(vo.getOrderStatusVo())) ;

	         if(ListUtil.isNotEmpty(vo.getOrderLinesVo()) && this.orderLines)
                  item.setOrderLines(orderLineConverter.toItem(vo.getOrderLinesVo()));


	         if(ListUtil.isNotEmpty(vo.getCommentsVo()) && this.comments)
                  item.setComments(commentConverter.toItem(vo.getCommentsVo()));



		return item;
 		}
 	}

 	 @Override 
 	public CommandVo toVo(Command item) {
 		if (item == null) {
    		return null;
      	} else {
			CommandVo vo = new CommandVo();

			if(item.isCommentResolution()!=null)
				vo.setCommentResolution(NumberUtil.toString(item.isCommentResolution()));
            if(item.getRegulationDate()!=null)
			    vo.setRegulationDate(DateUtil.formateDate(item.getRegulationDate()));	     
			 if(item.getLongitudeDelivery()!=null)
				vo.setLongitudeDelivery(NumberUtil.toString(item.getLongitudeDelivery()));
            if(item.getCommentResolutionDate ()!=null)
			    vo.setCommentResolutionDate (DateUtil.formateDate(item.getCommentResolutionDate ()));	     
            if(item.getDateSubmission()!=null)
			    vo.setDateSubmission(DateUtil.formateDate(item.getDateSubmission()));	     
			 if(item.getNbrTotalComment()!=null)
				vo.setNbrTotalComment(NumberUtil.toString(item.getNbrTotalComment()));
			 if(item.getYearCommand()!=null)
				vo.setYearCommand(NumberUtil.toString(item.getYearCommand()));
			 if(item.getLatitudeDelivery()!=null)
				vo.setLatitudeDelivery(NumberUtil.toString(item.getLatitudeDelivery()));
            if(item.getOrderDate()!=null)
			    vo.setOrderDate(DateUtil.formateDate(item.getOrderDate()));	     
			if(StringUtil.isNotEmpty(item.getAddress()))
				vo.setAddress(item.getAddress());
			
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 if(item.getDayCommand()!=null)
				vo.setDayCommand(NumberUtil.toString(item.getDayCommand()));
			 if(item.getMonthCommand()!=null)
				vo.setMonthCommand(NumberUtil.toString(item.getMonthCommand()));
			if(StringUtil.isNotEmpty(item.getRemark()))
				vo.setRemark(item.getRemark());
			
			 if(item.getTotal()!=null)
				vo.setTotal(NumberUtil.toString(item.getTotal()));
            if(item.getAdmin()!=null && this.admin) {
				   vo.setAdminVo(userConverter.toVo(item.getAdmin())) ;
			   } 
            if(item.getDeliveryMan()!=null && this.deliveryMan) {
				   vo.setDeliveryManVo(userConverter.toVo(item.getDeliveryMan())) ;
			   } 
            if(item.getClient()!=null && this.client) {
				   vo.setClientVo(userConverter.toVo(item.getClient())) ;
			   } 
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
            if(item.getOrderStatus()!=null && this.orderStatus) {
				   vo.setOrderStatusVo(orderStatusConverter.toVo(item.getOrderStatus())) ;
			   } 
	         if(ListUtil.isNotEmpty(item.getOrderLines()) && this.orderLines){
				
				 orderLineConverter.init(false);
                vo.setOrderLinesVo(orderLineConverter.toVo(item.getOrderLines()));
              	 orderLineConverter.init(true);
			 }
	         if(ListUtil.isNotEmpty(item.getComments()) && this.comments){
				
				 commentConverter.init(false);
                vo.setCommentsVo(commentConverter.toVo(item.getComments()));
              	 commentConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       admin = value;
       deliveryMan = value;
       client = value;
       city = value;
       orderStatus = value;
       orderLines = value;
       comments = value;
	}


	

	
	   public CommentConverter getCommentConverter(){
		return this.commentConverter;
	}  
        public void setCommentConverter(CommentConverter commentConverter ){
		 this.commentConverter = commentConverter;
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
	   public CityConverter getCityConverter(){
		return this.cityConverter;
	}  
        public void setCityConverter(CityConverter cityConverter ){
		 this.cityConverter = cityConverter;
	}  
	   public OrderStatusConverter getOrderStatusConverter(){
		return this.orderStatusConverter;
	}  
        public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
		 this.orderStatusConverter = orderStatusConverter;
	}  
	
	 public boolean  isAdmin(){
		  return this.admin;
	 }
	 public void  setAdmin(boolean admin){
		   this.admin = admin;
	 }
	 public boolean  isDeliveryMan(){
		  return this.deliveryMan;
	 }
	 public void  setDeliveryMan(boolean deliveryMan){
		   this.deliveryMan = deliveryMan;
	 }
	 public boolean  isClient(){
		  return this.client;
	 }
	 public void  setClient(boolean client){
		   this.client = client;
	 }
	 public boolean  isCity(){
		  return this.city;
	 }
	 public void  setCity(boolean city){
		   this.city = city;
	 }
	 public boolean  isOrderStatus(){
		  return this.orderStatus;
	 }
	 public void  setOrderStatus(boolean orderStatus){
		   this.orderStatus = orderStatus;
	 }
       public Boolean  isOrderLines(){
		 return this.orderLines ;
	   }
		 public void  setOrderLines(Boolean orderLines ){
            this.orderLines  = orderLines ;
		 }
       public Boolean  isComments(){
		 return this.comments ;
	   }
		 public void  setComments(Boolean comments ){
            this.comments  = comments ;
		 }
}