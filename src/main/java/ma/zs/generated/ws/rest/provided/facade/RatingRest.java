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
import ma.zs.generated.bean.Rating; 
import ma.zs.generated.service.facade.RatingService;
import ma.zs.generated.ws.rest.provided.converter.RatingConverter;
import ma.zs.generated.ws.rest.provided.vo.RatingVo;

@Api("Manages rating services")
@RestController
@RequestMapping("generated/rating")
public class RatingRest {

	@Autowired 
	private RatingService ratingService;
	
	@Autowired 
	private RatingConverter ratingConverter ;

    @ApiOperation("Saves the specified rating")
	@PostMapping("/")
	public RatingVo save(@RequestBody RatingVo ratingVo){
		Rating rating= ratingConverter.toItem(ratingVo);
	  rating=	ratingService.save(rating);
		return ratingConverter.toVo(rating);
	}

    @ApiOperation("Delete the specified rating")
	@DeleteMapping("/")
	public int delete(@RequestBody RatingVo ratingVo){
		Rating rating = ratingConverter.toItem(ratingVo);
		return ratingService.delete(rating);
	}

	@ApiOperation("Updates the specified rating")
	@PutMapping("/")
	public RatingVo update(@RequestBody RatingVo ratingVo){
		Rating rating= ratingConverter.toItem(ratingVo);
	  rating=	ratingService.update(rating);
		return ratingConverter.toVo(rating);
	}

	@ApiOperation("Finds a list of all ratings")
	@GetMapping("/")
	public List<RatingVo> findAll(){
		return ratingConverter.toVo(ratingService.findAll());
	}
    
	@ApiOperation("Finds a rating by id")
	@GetMapping("/id/{id}")
	public RatingVo findById(@PathVariable Long id){
		return  ratingConverter.toVo(ratingService.findById(id));
	}
	@ApiOperation("Deletes a rating by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 ratingService.deleteById(id);
	}



	
	@ApiOperation("Finds rating by id of client")
	@GetMapping("/client/id/{id}")
	public List<RatingVo> findByClientId(@PathVariable Long id){
		return ratingConverter.toVo(ratingService.findByClientId(id));
	}
	@ApiOperation("Deletes rating by id of client")
	@DeleteMapping("/client/id/{id}")
	public int deleteByClientId(@PathVariable Long id){
		return ratingService.deleteByClientId(id);
	}
     	
	
	@ApiOperation("Finds rating by id of orderLine")
	@GetMapping("/orderLine/id/{id}")
	public List<RatingVo> findByOrderLineId(@PathVariable Long id){
		return ratingConverter.toVo(ratingService.findByOrderLineId(id));
	}
	@ApiOperation("Deletes rating by id of orderLine")
	@DeleteMapping("/orderLine/id/{id}")
	public int deleteByOrderLineId(@PathVariable Long id){
		return ratingService.deleteByOrderLineId(id);
	}
     	
	
	@ApiOperation("Finds rating by id of collaborator")
	@GetMapping("/collaborator/id/{id}")
	public List<RatingVo> findByCollaboratorId(@PathVariable Long id){
		return ratingConverter.toVo(ratingService.findByCollaboratorId(id));
	}
	@ApiOperation("Deletes rating by id of collaborator")
	@DeleteMapping("/collaborator/id/{id}")
	public int deleteByCollaboratorId(@PathVariable Long id){
		return ratingService.deleteByCollaboratorId(id);
	}
     	
   
    @ApiOperation("Search rating by a specific criterion")
    @PostMapping("/search")
	public List<RatingVo> findByCriteria(@RequestBody RatingVo ratingVo){
       return ratingConverter.toVo(ratingService.findByCriteria(ratingVo));
	}	
	public RatingConverter getRatingConverter(){
		return ratingConverter;
	}
 
	public void setRatingConverter(RatingConverter ratingConverter){
		this.ratingConverter=ratingConverter;
	}

	public RatingService getRatingService(){
		return ratingService;
	}
	public void setRatingService( RatingService ratingService){
	 	this.ratingService=ratingService;
	}
	

}