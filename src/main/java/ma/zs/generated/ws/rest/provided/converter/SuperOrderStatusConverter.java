package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.SuperOrderStatus; 
import ma.zs.generated.ws.rest.provided.vo.SuperOrderStatusVo;

@Component 
public class SuperOrderStatusConverter extends AbstractConverter<SuperOrderStatus,SuperOrderStatusVo>{ 
	

	public  SuperOrderStatusConverter(){
		init(true);
	}

	@Override 
 	public SuperOrderStatus toItem(SuperOrderStatusVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	SuperOrderStatus item = new SuperOrderStatus();
			 if(StringUtil.isNotEmpty(vo.getColor()))
                  item.setColor(vo.getColor());
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getCode()))
                  item.setCode(vo.getCode());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public SuperOrderStatusVo toVo(SuperOrderStatus item) {
 		if (item == null) {
    		return null;
      	} else {
			SuperOrderStatusVo vo = new SuperOrderStatusVo();

			if(StringUtil.isNotEmpty(item.getColor()))
				vo.setColor(item.getColor());
			
			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			if(StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}