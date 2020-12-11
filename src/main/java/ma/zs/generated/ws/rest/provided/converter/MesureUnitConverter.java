package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.MesureUnit; 
import ma.zs.generated.ws.rest.provided.vo.MesureUnitVo;

@Component 
public class MesureUnitConverter extends AbstractConverter<MesureUnit,MesureUnitVo>{ 
	

	public  MesureUnitConverter(){
		init(true);
	}

	@Override 
 	public MesureUnit toItem(MesureUnitVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	MesureUnit item = new MesureUnit();
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public MesureUnitVo toVo(MesureUnit item) {
 		if (item == null) {
    		return null;
      	} else {
			MesureUnitVo vo = new MesureUnitVo();

			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}