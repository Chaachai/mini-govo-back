package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.User; 
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component 
public class UserConverter extends AbstractConverter<User,UserVo>{ 
	

	public  UserConverter(){
		init(true);
	}

	@Override 
 	public User toItem(UserVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	User item = new User();
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public UserVo toVo(User item) {
 		if (item == null) {
    		return null;
      	} else {
			UserVo vo = new UserVo();

			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}