package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.SuperCategoryProduct; 
import ma.zs.generated.ws.rest.provided.vo.SuperCategoryProductVo;

@Component 
public class SuperCategoryProductConverter extends AbstractConverter<SuperCategoryProduct,SuperCategoryProductVo>{ 
	

	public  SuperCategoryProductConverter(){
		init(true);
	}

	@Override 
 	public SuperCategoryProduct toItem(SuperCategoryProductVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	SuperCategoryProduct item = new SuperCategoryProduct();
			 if(StringUtil.isNotEmpty(vo.getDescription()))
                  item.setDescription(vo.getDescription());
			 if(StringUtil.isNotEmpty(vo.getImagePath()))
                  item.setImagePath(vo.getImagePath());
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public SuperCategoryProductVo toVo(SuperCategoryProduct item) {
 		if (item == null) {
    		return null;
      	} else {
			SuperCategoryProductVo vo = new SuperCategoryProductVo();

			if(StringUtil.isNotEmpty(item.getDescription()))
				vo.setDescription(item.getDescription());
			
			if(StringUtil.isNotEmpty(item.getImagePath()))
				vo.setImagePath(item.getImagePath());
			
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