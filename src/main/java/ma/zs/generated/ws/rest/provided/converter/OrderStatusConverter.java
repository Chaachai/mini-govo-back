package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.OrderStatus; 
import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;

@Component 
public class OrderStatusConverter extends AbstractConverter<OrderStatus,OrderStatusVo>{ 
	
	   @Autowired
         private SuperOrderStatusConverter superOrderStatusConverter ;
    private Boolean superOrderStatus;

	public  OrderStatusConverter(){
		init(true);
	}

	@Override 
 	public OrderStatus toItem(OrderStatusVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	OrderStatus item = new OrderStatus();
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getColor ()))
                  item.setColor (vo.getColor ());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getCode()))
                  item.setCode(vo.getCode());
             if(vo.getSuperOrderStatusVo()!=null && this.superOrderStatus)
			     item.setSuperOrderStatus(superOrderStatusConverter.toItem(vo.getSuperOrderStatusVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public OrderStatusVo toVo(OrderStatus item) {
 		if (item == null) {
    		return null;
      	} else {
			OrderStatusVo vo = new OrderStatusVo();

			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			if(StringUtil.isNotEmpty(item.getColor ()))
				vo.setColor (item.getColor ());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			if(StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());
			
            if(item.getSuperOrderStatus()!=null && this.superOrderStatus) {
				   vo.setSuperOrderStatusVo(superOrderStatusConverter.toVo(item.getSuperOrderStatus())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       superOrderStatus = value;
	}


	

	
	   public SuperOrderStatusConverter getSuperOrderStatusConverter(){
		return this.superOrderStatusConverter;
	}  
        public void setSuperOrderStatusConverter(SuperOrderStatusConverter superOrderStatusConverter ){
		 this.superOrderStatusConverter = superOrderStatusConverter;
	}  
	
	 public boolean  isSuperOrderStatus(){
		  return this.superOrderStatus;
	 }
	 public void  setSuperOrderStatus(boolean superOrderStatus){
		   this.superOrderStatus = superOrderStatus;
	 }
}