package  ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.SuperCategoryProduct; 
import ma.zs.generated.service.facade.SuperCategoryProductService;
import ma.zs.generated.ws.rest.provided.converter.SuperCategoryProductConverter;
import ma.zs.generated.ws.rest.provided.vo.SuperCategoryProductVo;

@Api("Manages superCategoryProduct services")
@RestController
@RequestMapping("generated/superCategoryProduct")
public class SuperCategoryProductRest {

	@Autowired 
	private SuperCategoryProductService superCategoryProductService;
	
	@Autowired 
	private SuperCategoryProductConverter superCategoryProductConverter ;

    @ApiOperation("Saves the specified superCategoryProduct")
	@PostMapping("/")
	public SuperCategoryProductVo save(@RequestBody SuperCategoryProductVo superCategoryProductVo){
		SuperCategoryProduct superCategoryProduct= superCategoryProductConverter.toItem(superCategoryProductVo);
	  superCategoryProduct=	superCategoryProductService.save(superCategoryProduct);
	  return superCategoryProductConverter.toVo(superCategoryProduct);
	}

	/*
	public SuperCategoryProductVo save(@RequestParam(value = "data") SuperCategoryProductVo superCategoryProductVo, @RequestParam(value = "file",required = false)MultipartFile file){
		SuperCategoryProduct superCategoryProduct= superCategoryProductConverter.toItem(superCategoryProductVo);
	  superCategoryProduct=	superCategoryProductService.save(superCategoryProduct);
		return superCategoryProductConverter.toVo(superCategoryProduct);
	}
	 */

    @ApiOperation("Delete the specified superCategoryProduct")
	@DeleteMapping("/")
	public int delete(@RequestBody SuperCategoryProductVo superCategoryProductVo){
		SuperCategoryProduct superCategoryProduct = superCategoryProductConverter.toItem(superCategoryProductVo);
		return superCategoryProductService.delete(superCategoryProduct);
	}

	@ApiOperation("Updates the specified superCategoryProduct")
	@PutMapping("/")
	public SuperCategoryProductVo update(@RequestBody SuperCategoryProductVo superCategoryProductVo){
		SuperCategoryProduct superCategoryProduct= superCategoryProductConverter.toItem(superCategoryProductVo);
	  superCategoryProduct=	superCategoryProductService.update(superCategoryProduct);
		return superCategoryProductConverter.toVo(superCategoryProduct);
	}

	@ApiOperation("Finds a list of all superCategoryProducts")
	@GetMapping("/")
	public List<SuperCategoryProductVo> findAll(){
		return superCategoryProductConverter.toVo(superCategoryProductService.findAll());
	}
    
	@ApiOperation("Finds a superCategoryProduct by id")
	@GetMapping("/id/{id}")
	public SuperCategoryProductVo findById(@PathVariable Long id){
		return  superCategoryProductConverter.toVo(superCategoryProductService.findById(id));
	}
	@ApiOperation("Deletes a superCategoryProduct by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 superCategoryProductService.deleteById(id);
	}

	@ApiOperation("Finds a  superCategoryProduct by label")
    @GetMapping("/label/{label}")
	public SuperCategoryProductVo findByLabel(@PathVariable String label){
		return  superCategoryProductConverter.toVo(superCategoryProductService.findByLabel(label));
	}
	@ApiOperation("Deletes a  superCategoryProduct by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  superCategoryProductService.deleteByLabel(label);
	}
	


   
    @ApiOperation("Search superCategoryProduct by a specific criterion")
    @PostMapping("/search")
	public List<SuperCategoryProductVo> findByCriteria(@RequestBody SuperCategoryProductVo superCategoryProductVo){
       return superCategoryProductConverter.toVo(superCategoryProductService.findByCriteria(superCategoryProductVo));
	}	
	public SuperCategoryProductConverter getSuperCategoryProductConverter(){
		return superCategoryProductConverter;
	}
 
	public void setSuperCategoryProductConverter(SuperCategoryProductConverter superCategoryProductConverter){
		this.superCategoryProductConverter=superCategoryProductConverter;
	}

	public SuperCategoryProductService getSuperCategoryProductService(){
		return superCategoryProductService;
	}
	public void setSuperCategoryProductService( SuperCategoryProductService superCategoryProductService){
	 	this.superCategoryProductService=superCategoryProductService;
	}
	

}