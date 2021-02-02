package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.OrderLine; 
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;

@Component 
public class OrderLineConverter extends AbstractConverter<OrderLine,OrderLineVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private CommandConverter commandConverter ;
	   @Autowired
         private ProductConverter productConverter ;
	   @Autowired
         private OrderStatusConverter orderStatusConverter ;
    private Boolean orderStatus ;
    private Boolean deliveryMan;
    private Boolean collaborator;
    private Boolean command;
    private Boolean product;

	public  OrderLineConverter(){
		init(true);
	}

	@Override 
 	public OrderLine toItem(OrderLineVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	OrderLine item = new OrderLine();
             if(StringUtil.isNotEmpty(vo.getDateAcceptationCollaborator()))
			      item.setDateAcceptationCollaborator(DateUtil.parse(vo.getDateAcceptationCollaborator()));
             if(StringUtil.isNotEmpty(vo.getDatePreparationCollaborator()))
			      item.setDatePreparationCollaborator(DateUtil.parse(vo.getDatePreparationCollaborator()));
             if(StringUtil.isNotEmpty(vo.getDateRecuperationDelivery()))
			      item.setDateRecuperationDelivery(DateUtil.parse(vo.getDateRecuperationDelivery()));
			 if(StringUtil.isNotEmpty(vo.getRejectionReason()))
                  item.setRejectionReason(vo.getRejectionReason());
			 if(StringUtil.isNotEmpty(vo.getDescription()))
                  item.setDescription(vo.getDescription());
             if(StringUtil.isNotEmpty(vo.getDateSubmissionToCollaborator()))
			      item.setDateSubmissionToCollaborator(DateUtil.parse(vo.getDateSubmissionToCollaborator()));
			 if(StringUtil.isNotEmpty(vo.getLongitudeCollaborator()))
                  item.setLongitudeCollaborator(NumberUtil.toBigDecimal(vo.getLongitudeCollaborator()));
			 if(StringUtil.isNotEmpty(vo.getLatitudeCollaborator()))
                  item.setLatitudeCollaborator(NumberUtil.toBigDecimal(vo.getLatitudeCollaborator()));
             if(StringUtil.isNotEmpty(vo.getDateRejectionCllaborator()))
			      item.setDateRejectionCllaborator(DateUtil.parse(vo.getDateRejectionCllaborator()));
             if(StringUtil.isNotEmpty(vo.getDateRejectionDelivery()))
			      item.setDateRejectionDelivery(DateUtil.parse(vo.getDateRejectionDelivery()));
             if(StringUtil.isNotEmpty(vo.getDateSubmissionDelivery()))
			      item.setDateSubmissionDelivery(DateUtil.parse(vo.getDateSubmissionDelivery()));
             if(StringUtil.isNotEmpty(vo.getDateAcceptationDelivery()))
			      item.setDateAcceptationDelivery(DateUtil.parse(vo.getDateAcceptationDelivery()));
			 if(StringUtil.isNotEmpty(vo.getDateDelivery()))
                  item.setDateDelivery(vo.getDateDelivery());
			 if(StringUtil.isNotEmpty(vo.getPreparedQte()))
                  item.setPreparedQte(NumberUtil.toBigDecimal(vo.getPreparedQte()));
			 if(StringUtil.isNotEmpty(vo.getDeliveredQte()))
                  item.setDeliveredQte(NumberUtil.toBigDecimal(vo.getDeliveredQte()));
			 if(StringUtil.isNotEmpty(vo.getSentQte()))
                  item.setSentQte(NumberUtil.toBigDecimal(vo.getSentQte()));
			 if(StringUtil.isNotEmpty(vo.getPrice()))
                  item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getOrderedQte()))
                  item.setOrderedQte(NumberUtil.toBigDecimal(vo.getOrderedQte()));
             if(vo.getOrderStatusVo()!=null && this.orderStatus )
			     item.setOrderStatus (orderStatusConverter.toItem(vo.getOrderStatusVo())) ;
             if(vo.getDeliveryManVo()!=null && this.deliveryMan)
			     item.setDeliveryMan(userConverter.toItem(vo.getDeliveryManVo())) ;
             if(vo.getCollaboratorVo()!=null && this.collaborator)
			     item.setCollaborator(userConverter.toItem(vo.getCollaboratorVo())) ;
             if(vo.getCommandVo()!=null && this.command)
			     item.setCommand(commandConverter.toItem(vo.getCommandVo())) ;
             if(vo.getProductVo()!=null && this.product)
			     item.setProduct(productConverter.toItem(vo.getProductVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public OrderLineVo toVo(OrderLine item) {
 		if (item == null) {
    		return null;
      	} else {
			OrderLineVo vo = new OrderLineVo();

            if(item.getDateAcceptationCollaborator()!=null)
			    vo.setDateAcceptationCollaborator(DateUtil.formateDate(item.getDateAcceptationCollaborator()));	     
            if(item.getDatePreparationCollaborator()!=null)
			    vo.setDatePreparationCollaborator(DateUtil.formateDate(item.getDatePreparationCollaborator()));	     
            if(item.getDateRecuperationDelivery()!=null)
			    vo.setDateRecuperationDelivery(DateUtil.formateDate(item.getDateRecuperationDelivery()));	     
			if(StringUtil.isNotEmpty(item.getRejectionReason()))
				vo.setRejectionReason(item.getRejectionReason());
			
			if(StringUtil.isNotEmpty(item.getDescription()))
				vo.setDescription(item.getDescription());
			
            if(item.getDateSubmissionToCollaborator()!=null)
			    vo.setDateSubmissionToCollaborator(DateUtil.formateDate(item.getDateSubmissionToCollaborator()));	     
			 if(item.getLongitudeCollaborator()!=null)
				vo.setLongitudeCollaborator(NumberUtil.toString(item.getLongitudeCollaborator()));
			 if(item.getLatitudeCollaborator()!=null)
				vo.setLatitudeCollaborator(NumberUtil.toString(item.getLatitudeCollaborator()));
            if(item.getDateRejectionCllaborator()!=null)
			    vo.setDateRejectionCllaborator(DateUtil.formateDate(item.getDateRejectionCllaborator()));	     
            if(item.getDateRejectionDelivery()!=null)
			    vo.setDateRejectionDelivery(DateUtil.formateDate(item.getDateRejectionDelivery()));	     
            if(item.getDateSubmissionDelivery()!=null)
			    vo.setDateSubmissionDelivery(DateUtil.formateDate(item.getDateSubmissionDelivery()));	     
            if(item.getDateAcceptationDelivery()!=null)
			    vo.setDateAcceptationDelivery(DateUtil.formateDate(item.getDateAcceptationDelivery()));	     
			if(StringUtil.isNotEmpty(item.getDateDelivery()))
				vo.setDateDelivery(item.getDateDelivery());
			
			 if(item.getPreparedQte()!=null)
				vo.setPreparedQte(NumberUtil.toString(item.getPreparedQte()));
			 if(item.getSentQte()!=null)
				vo.setSentQte(NumberUtil.toString(item.getSentQte()));
			 if(item.getPrice()!=null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 if(item.getOrderedQte()!=null)
				vo.setOrderedQte(NumberUtil.toString(item.getOrderedQte()));
            if(item.getOrderStatus ()!=null && this.orderStatus ) {
				   vo.setOrderStatusVo(orderStatusConverter.toVo(item.getOrderStatus ())) ;
			   } 
            if(item.getDeliveryMan()!=null && this.deliveryMan) {
				   vo.setDeliveryManVo(userConverter.toVo(item.getDeliveryMan())) ;
			   } 
            if(item.getCollaborator()!=null && this.collaborator) {
				   vo.setCollaboratorVo(userConverter.toVo(item.getCollaborator())) ;
			   } 
            if(item.getCommand()!=null && this.command) {
				   vo.setCommandVo(commandConverter.toVo(item.getCommand())) ;
			   } 
            if(item.getProduct()!=null && this.product) {
				   vo.setProductVo(productConverter.toVo(item.getProduct())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       orderStatus  = value;
       deliveryMan = value;
       collaborator = value;
       command = value;
       product = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public CommandConverter getCommandConverter(){
		return this.commandConverter;
	}  
        public void setCommandConverter(CommandConverter commandConverter ){
		 this.commandConverter = commandConverter;
	}  
	   public ProductConverter getProductConverter(){
		return this.productConverter;
	}  
        public void setProductConverter(ProductConverter productConverter ){
		 this.productConverter = productConverter;
	}  
	   public OrderStatusConverter getOrderStatusConverter(){
		return this.orderStatusConverter;
	}  
        public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
		 this.orderStatusConverter = orderStatusConverter;
	}  
	
	 public boolean  isOrderStatus (){
		  return this.orderStatus ;
	 }
	 public void  setOrderStatus (boolean orderStatus ){
		   this.orderStatus  = orderStatus ;
	 }
	 public boolean  isDeliveryMan(){
		  return this.deliveryMan;
	 }
	 public void  setDeliveryMan(boolean deliveryMan){
		   this.deliveryMan = deliveryMan;
	 }
	 public boolean  isCollaborator(){
		  return this.collaborator;
	 }
	 public void  setCollaborator(boolean collaborator){
		   this.collaborator = collaborator;
	 }
	 public boolean  isCommand(){
		  return this.command;
	 }
	 public void  setCommand(boolean command){
		   this.command = command;
	 }
	 public boolean  isProduct(){
		  return this.product;
	 }
	 public void  setProduct(boolean product){
		   this.product = product;
	 }
}