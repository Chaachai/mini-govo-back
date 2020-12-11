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
import ma.zs.generated.bean.SuperOrderStatus; 
import ma.zs.generated.service.facade.SuperOrderStatusService;
import ma.zs.generated.ws.rest.provided.converter.SuperOrderStatusConverter;
import ma.zs.generated.ws.rest.provided.vo.SuperOrderStatusVo;

@Api("Manages superOrderStatus services")
@RestController
@RequestMapping("generated/superOrderStatus")
public class SuperOrderStatusRest {

	@Autowired 
	private SuperOrderStatusService superOrderStatusService;
	
	@Autowired 
	private SuperOrderStatusConverter superOrderStatusConverter ;

    @ApiOperation("Saves the specified superOrderStatus")
	@PostMapping("/")
	public SuperOrderStatusVo save(@RequestBody SuperOrderStatusVo superOrderStatusVo){
		SuperOrderStatus superOrderStatus= superOrderStatusConverter.toItem(superOrderStatusVo);
	  superOrderStatus=	superOrderStatusService.save(superOrderStatus);
		return superOrderStatusConverter.toVo(superOrderStatus);
	}

    @ApiOperation("Delete the specified superOrderStatus")
	@DeleteMapping("/")
	public int delete(@RequestBody SuperOrderStatusVo superOrderStatusVo){
		SuperOrderStatus superOrderStatus = superOrderStatusConverter.toItem(superOrderStatusVo);
		return superOrderStatusService.delete(superOrderStatus);
	}

	@ApiOperation("Updates the specified superOrderStatus")
	@PutMapping("/")
	public SuperOrderStatusVo update(@RequestBody SuperOrderStatusVo superOrderStatusVo){
		SuperOrderStatus superOrderStatus= superOrderStatusConverter.toItem(superOrderStatusVo);
	  superOrderStatus=	superOrderStatusService.update(superOrderStatus);
		return superOrderStatusConverter.toVo(superOrderStatus);
	}

	@ApiOperation("Finds a list of all superOrderStatuss")
	@GetMapping("/")
	public List<SuperOrderStatusVo> findAll(){
		return superOrderStatusConverter.toVo(superOrderStatusService.findAll());
	}
    
	@ApiOperation("Finds a superOrderStatus by id")
	@GetMapping("/id/{id}")
	public SuperOrderStatusVo findById(@PathVariable Long id){
		return  superOrderStatusConverter.toVo(superOrderStatusService.findById(id));
	}
	@ApiOperation("Deletes a superOrderStatus by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 superOrderStatusService.deleteById(id);
	}

	@ApiOperation("Finds a  superOrderStatus by code")
    @GetMapping("/code/{code}")
	public SuperOrderStatusVo findByCode(@PathVariable String code){
		return  superOrderStatusConverter.toVo(superOrderStatusService.findByCode(code));
	}
	@ApiOperation("Deletes a  superOrderStatus by code")
    @DeleteMapping("/code/{code}")
	public int deleteByCode(@PathVariable String code){
		return  superOrderStatusService.deleteByCode(code);
	}
	


   
    @ApiOperation("Search superOrderStatus by a specific criterion")
    @PostMapping("/search")
	public List<SuperOrderStatusVo> findByCriteria(@RequestBody SuperOrderStatusVo superOrderStatusVo){
       return superOrderStatusConverter.toVo(superOrderStatusService.findByCriteria(superOrderStatusVo));
	}	
	public SuperOrderStatusConverter getSuperOrderStatusConverter(){
		return superOrderStatusConverter;
	}
 
	public void setSuperOrderStatusConverter(SuperOrderStatusConverter superOrderStatusConverter){
		this.superOrderStatusConverter=superOrderStatusConverter;
	}

	public SuperOrderStatusService getSuperOrderStatusService(){
		return superOrderStatusService;
	}
	public void setSuperOrderStatusService( SuperOrderStatusService superOrderStatusService){
	 	this.superOrderStatusService=superOrderStatusService;
	}
	

}