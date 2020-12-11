package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Comment; 
import ma.zs.generated.ws.rest.provided.vo.CommentVo;

@Component 
public class CommentConverter extends AbstractConverter<Comment,CommentVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private CommandConverter commandConverter ;
    private Boolean user;
    private Boolean command;

	public  CommentConverter(){
		init(true);
	}

	@Override 
 	public Comment toItem(CommentVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Comment item = new Comment();
             if(StringUtil.isNotEmpty(vo.getCommentDate()))
			      item.setCommentDate(DateUtil.parse(vo.getCommentDate()));
			 if(StringUtil.isNotEmpty(vo.getMessage()))
                  item.setMessage(vo.getMessage());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getUserVo()!=null && this.user)
			     item.setUser(userConverter.toItem(vo.getUserVo())) ;
             if(vo.getCommandVo()!=null && this.command)
			     item.setCommand(commandConverter.toItem(vo.getCommandVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public CommentVo toVo(Comment item) {
 		if (item == null) {
    		return null;
      	} else {
			CommentVo vo = new CommentVo();

            if(item.getCommentDate()!=null)
			    vo.setCommentDate(DateUtil.formateDate(item.getCommentDate()));	     
			if(StringUtil.isNotEmpty(item.getMessage()))
				vo.setMessage(item.getMessage());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getUser()!=null && this.user) {
				   vo.setUserVo(userConverter.toVo(item.getUser())) ;
			   } 
            if(item.getCommand()!=null && this.command) {
				   vo.setCommandVo(commandConverter.toVo(item.getCommand())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       user = value;
       command = value;
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
	
	 public boolean  isUser(){
		  return this.user;
	 }
	 public void  setUser(boolean user){
		   this.user = user;
	 }
	 public boolean  isCommand(){
		  return this.command;
	 }
	 public void  setCommand(boolean command){
		   this.command = command;
	 }
}