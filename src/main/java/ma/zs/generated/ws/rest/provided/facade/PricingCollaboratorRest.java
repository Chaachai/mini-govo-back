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
import ma.zs.generated.bean.PricingCollaborator; 
import ma.zs.generated.service.facade.PricingCollaboratorService;
import ma.zs.generated.ws.rest.provided.converter.PricingCollaboratorConverter;
import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;

@Api("Manages pricingCollaborator services")
@RestController
@RequestMapping("generated/pricingCollaborator")
public class PricingCollaboratorRest {

	@Autowired 
	private PricingCollaboratorService pricingCollaboratorService;
	
	@Autowired 
	private PricingCollaboratorConverter pricingCollaboratorConverter ;

    @ApiOperation("Saves the specified pricingCollaborator")
	@PostMapping("/")
	public PricingCollaboratorVo save(@RequestBody PricingCollaboratorVo pricingCollaboratorVo){
		PricingCollaborator pricingCollaborator= pricingCollaboratorConverter.toItem(pricingCollaboratorVo);
	  pricingCollaborator=	pricingCollaboratorService.save(pricingCollaborator);
		return pricingCollaboratorConverter.toVo(pricingCollaborator);
	}

    @ApiOperation("Delete the specified pricingCollaborator")
	@DeleteMapping("/")
	public int delete(@RequestBody PricingCollaboratorVo pricingCollaboratorVo){
		PricingCollaborator pricingCollaborator = pricingCollaboratorConverter.toItem(pricingCollaboratorVo);
		return pricingCollaboratorService.delete(pricingCollaborator);
	}

	@ApiOperation("Updates the specified pricingCollaborator")
	@PutMapping("/")
	public PricingCollaboratorVo update(@RequestBody PricingCollaboratorVo pricingCollaboratorVo){
		PricingCollaborator pricingCollaborator= pricingCollaboratorConverter.toItem(pricingCollaboratorVo);
	  pricingCollaborator=	pricingCollaboratorService.update(pricingCollaborator);
		return pricingCollaboratorConverter.toVo(pricingCollaborator);
	}

	@ApiOperation("Finds a list of all pricingCollaborators")
	@GetMapping("/")
	public List<PricingCollaboratorVo> findAll(){
		return pricingCollaboratorConverter.toVo(pricingCollaboratorService.findAll());
	}
    
	@ApiOperation("Finds a pricingCollaborator by id")
	@GetMapping("/id/{id}")
	public PricingCollaboratorVo findById(@PathVariable Long id){
		return  pricingCollaboratorConverter.toVo(pricingCollaboratorService.findById(id));
	}
	@ApiOperation("Deletes a pricingCollaborator by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 pricingCollaboratorService.deleteById(id);
	}



   
    @ApiOperation("Search pricingCollaborator by a specific criterion")
    @PostMapping("/search")
	public List<PricingCollaboratorVo> findByCriteria(@RequestBody PricingCollaboratorVo pricingCollaboratorVo){
       return pricingCollaboratorConverter.toVo(pricingCollaboratorService.findByCriteria(pricingCollaboratorVo));
	}	
	public PricingCollaboratorConverter getPricingCollaboratorConverter(){
		return pricingCollaboratorConverter;
	}
 
	public void setPricingCollaboratorConverter(PricingCollaboratorConverter pricingCollaboratorConverter){
		this.pricingCollaboratorConverter=pricingCollaboratorConverter;
	}

	public PricingCollaboratorService getPricingCollaboratorService(){
		return pricingCollaboratorService;
	}
	public void setPricingCollaboratorService( PricingCollaboratorService pricingCollaboratorService){
	 	this.pricingCollaboratorService=pricingCollaboratorService;
	}
	

}