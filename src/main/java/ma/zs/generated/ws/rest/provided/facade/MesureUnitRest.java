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
import ma.zs.generated.bean.MesureUnit; 
import ma.zs.generated.service.facade.MesureUnitService;
import ma.zs.generated.ws.rest.provided.converter.MesureUnitConverter;
import ma.zs.generated.ws.rest.provided.vo.MesureUnitVo;

@Api("Manages mesureUnit services")
@RestController
@RequestMapping("generated/mesureUnit")
public class MesureUnitRest {

	@Autowired 
	private MesureUnitService mesureUnitService;
	
	@Autowired 
	private MesureUnitConverter mesureUnitConverter ;

    @ApiOperation("Saves the specified mesureUnit")
	@PostMapping("/")
	public MesureUnitVo save(@RequestBody MesureUnitVo mesureUnitVo){
		MesureUnit mesureUnit= mesureUnitConverter.toItem(mesureUnitVo);
	  mesureUnit=	mesureUnitService.save(mesureUnit);
		return mesureUnitConverter.toVo(mesureUnit);
	}

    @ApiOperation("Delete the specified mesureUnit")
	@DeleteMapping("/")
	public int delete(@RequestBody MesureUnitVo mesureUnitVo){
		MesureUnit mesureUnit = mesureUnitConverter.toItem(mesureUnitVo);
		return mesureUnitService.delete(mesureUnit);
	}

	@ApiOperation("Updates the specified mesureUnit")
	@PutMapping("/")
	public MesureUnitVo update(@RequestBody MesureUnitVo mesureUnitVo){
		MesureUnit mesureUnit= mesureUnitConverter.toItem(mesureUnitVo);
	  mesureUnit=	mesureUnitService.update(mesureUnit);
		return mesureUnitConverter.toVo(mesureUnit);
	}

	@ApiOperation("Finds a list of all mesureUnits")
	@GetMapping("/")
	public List<MesureUnitVo> findAll(){
		return mesureUnitConverter.toVo(mesureUnitService.findAll());
	}
    
	@ApiOperation("Finds a mesureUnit by id")
	@GetMapping("/id/{id}")
	public MesureUnitVo findById(@PathVariable Long id){
		return  mesureUnitConverter.toVo(mesureUnitService.findById(id));
	}
	@ApiOperation("Deletes a mesureUnit by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 mesureUnitService.deleteById(id);
	}

	@ApiOperation("Finds a  mesureUnit by label")
    @GetMapping("/label/{label}")
	public MesureUnitVo findByLabel(@PathVariable String label){
		return  mesureUnitConverter.toVo(mesureUnitService.findByLabel(label));
	}
	@ApiOperation("Deletes a  mesureUnit by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  mesureUnitService.deleteByLabel(label);
	}
	


   
    @ApiOperation("Search mesureUnit by a specific criterion")
    @PostMapping("/search")
	public List<MesureUnitVo> findByCriteria(@RequestBody MesureUnitVo mesureUnitVo){
       return mesureUnitConverter.toVo(mesureUnitService.findByCriteria(mesureUnitVo));
	}	
	public MesureUnitConverter getMesureUnitConverter(){
		return mesureUnitConverter;
	}
 
	public void setMesureUnitConverter(MesureUnitConverter mesureUnitConverter){
		this.mesureUnitConverter=mesureUnitConverter;
	}

	public MesureUnitService getMesureUnitService(){
		return mesureUnitService;
	}
	public void setMesureUnitService( MesureUnitService mesureUnitService){
	 	this.mesureUnitService=mesureUnitService;
	}
	

}