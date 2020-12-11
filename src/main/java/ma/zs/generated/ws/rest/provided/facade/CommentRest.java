package  ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.Comment; 
import ma.zs.generated.service.facade.CommentService;
import ma.zs.generated.ws.rest.provided.converter.CommentConverter;
import ma.zs.generated.ws.rest.provided.vo.CommentVo;

@Api("Manages comment services")
@RestController
@RequestMapping("generated/comment")
public class CommentRest {

	@Autowired 
	private CommentService commentService;
	
	@Autowired 
	private CommentConverter commentConverter ;

    @ApiOperation("Saves the specified comment")
	@PostMapping("/")
	public CommentVo save(@RequestBody CommentVo commentVo){
		Comment comment= commentConverter.toItem(commentVo);
	  comment=	commentService.save(comment);
		return commentConverter.toVo(comment);
	}

    @ApiOperation("Delete the specified comment")
	@DeleteMapping("/")
	public int delete(@RequestBody CommentVo commentVo){
		Comment comment = commentConverter.toItem(commentVo);
		return commentService.delete(comment);
	}

	@ApiOperation("Updates the specified comment")
	@PutMapping("/")
	public CommentVo update(@RequestBody CommentVo commentVo){
		Comment comment= commentConverter.toItem(commentVo);
	  comment=	commentService.update(comment);
		return commentConverter.toVo(comment);
	}

	@ApiOperation("Finds a list of all comments")
	@GetMapping("/")
	public List<CommentVo> findAll(){
		return commentConverter.toVo(commentService.findAll());
	}
    
	@ApiOperation("Finds a comment by id")
	@GetMapping("/id/{id}")
	public CommentVo findById(@PathVariable Long id){
		return  commentConverter.toVo(commentService.findById(id));
	}
	@ApiOperation("Deletes a comment by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 commentService.deleteById(id);
	}



	
	@ApiOperation("Finds comment by id of user")
	@GetMapping("/user/id/{id}")
	public List<CommentVo> findByUserId(@PathVariable Long id){
		return commentConverter.toVo(commentService.findByUserId(id));
	}
	@ApiOperation("Deletes comment by id of user")
	@DeleteMapping("/user/id/{id}")
	public int deleteByUserId(@PathVariable Long id){
		return commentService.deleteByUserId(id);
	}
     	
    @ApiOperation("Finds a comment by reference of command")
	@GetMapping("/command/reference/{reference}")
	public List<CommentVo> findByCommandReference(@PathVariable String reference){
		return commentConverter.toVo(commentService.findByCommandReference(reference));
	}
	
	@ApiOperation("Deletes a comment by reference of command")
	@DeleteMapping("/command/reference/{reference}")
	public int deleteByCommandReference(@PathVariable String reference){
		return commentService.deleteByCommandReference(reference);
	}
	
	@ApiOperation("Finds comment by id of command")
	@GetMapping("/command/id/{id}")
	public List<CommentVo> findByCommandId(@PathVariable Long id){
		return commentConverter.toVo(commentService.findByCommandId(id));
	}
	@ApiOperation("Deletes comment by id of command")
	@DeleteMapping("/command/id/{id}")
	public int deleteByCommandId(@PathVariable Long id){
		return commentService.deleteByCommandId(id);
	}
     	
   
    @ApiOperation("Search comment by a specific criterion")
    @PostMapping("/search")
	public List<CommentVo> findByCriteria(@RequestBody CommentVo commentVo){
       return commentConverter.toVo(commentService.findByCriteria(commentVo));
	}	
	public CommentConverter getCommentConverter(){
		return commentConverter;
	}
 
	public void setCommentConverter(CommentConverter commentConverter){
		this.commentConverter=commentConverter;
	}

	public CommentService getCommentService(){
		return commentService;
	}
	public void setCommentService( CommentService commentService){
	 	this.commentService=commentService;
	}
	

}