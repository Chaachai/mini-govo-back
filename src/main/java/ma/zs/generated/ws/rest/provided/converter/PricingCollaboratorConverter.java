package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.PricingCollaborator; 
import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;

@Component 
public class PricingCollaboratorConverter extends AbstractConverter<PricingCollaborator,PricingCollaboratorVo>{ 
	

	public  PricingCollaboratorConverter(){
		init(true);
	}

	@Override 
 	public PricingCollaborator toItem(PricingCollaboratorVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	PricingCollaborator item = new PricingCollaborator();
			 if(StringUtil.isNotEmpty(vo.getPriceMax()))
                  item.setPriceMax(NumberUtil.toBigDecimal(vo.getPriceMax()));
			 if(StringUtil.isNotEmpty(vo.getPrice()))
                  item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
			 if(StringUtil.isNotEmpty(vo.getPriceMin()))
                  item.setPriceMin(NumberUtil.toBigDecimal(vo.getPriceMin()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public PricingCollaboratorVo toVo(PricingCollaborator item) {
 		if (item == null) {
    		return null;
      	} else {
			PricingCollaboratorVo vo = new PricingCollaboratorVo();

			 if(item.getPriceMax()!=null)
				vo.setPriceMax(NumberUtil.toString(item.getPriceMax()));
			 if(item.getPrice()!=null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
			 if(item.getPriceMin()!=null)
				vo.setPriceMin(NumberUtil.toString(item.getPriceMin()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}