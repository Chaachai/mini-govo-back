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
import ma.zs.generated.bean.CategoryProduit; 
import ma.zs.generated.service.facade.CategoryProduitService;
import ma.zs.generated.ws.rest.provided.converter.CategoryProduitConverter;
import ma.zs.generated.ws.rest.provided.vo.CategoryProduitVo;

@Api("Manages categoryProduit services")
@RestController
@RequestMapping("generated/categoryProduit")
public class CategoryProduitRest {

	@Autowired 
	private CategoryProduitService categoryProduitService;
	
	@Autowired 
	private CategoryProduitConverter categoryProduitConverter ;

    @ApiOperation("Saves the specified categoryProduit")
	@PostMapping("/")
	public CategoryProduitVo save(@RequestBody CategoryProduitVo categoryProduitVo){
		CategoryProduit categoryProduit= categoryProduitConverter.toItem(categoryProduitVo);
	  categoryProduit=	categoryProduitService.save(categoryProduit);
		return categoryProduitConverter.toVo(categoryProduit);
	}

    @ApiOperation("Delete the specified categoryProduit")
	@DeleteMapping("/")
	public int delete(@RequestBody CategoryProduitVo categoryProduitVo){
		CategoryProduit categoryProduit = categoryProduitConverter.toItem(categoryProduitVo);
		return categoryProduitService.delete(categoryProduit);
	}

	@ApiOperation("Updates the specified categoryProduit")
	@PutMapping("/")
	public CategoryProduitVo update(@RequestBody CategoryProduitVo categoryProduitVo){
		CategoryProduit categoryProduit= categoryProduitConverter.toItem(categoryProduitVo);
	  categoryProduit=	categoryProduitService.update(categoryProduit);
		return categoryProduitConverter.toVo(categoryProduit);
	}

	@ApiOperation("Finds a list of all categoryProduits")
	@GetMapping("/")
	public List<CategoryProduitVo> findAll(){
		return categoryProduitConverter.toVo(categoryProduitService.findAll());
	}
    
	@ApiOperation("Finds a categoryProduit by id")
	@GetMapping("/id/{id}")
	public CategoryProduitVo findById(@PathVariable Long id){
		return  categoryProduitConverter.toVo(categoryProduitService.findById(id));
	}
	@ApiOperation("Deletes a categoryProduit by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 categoryProduitService.deleteById(id);
	}

	@ApiOperation("Finds a  categoryProduit by label")
    @GetMapping("/label/{label}")
	public CategoryProduitVo findByLabel(@PathVariable String label){
		return  categoryProduitConverter.toVo(categoryProduitService.findByLabel(label));
	}
	@ApiOperation("Deletes a  categoryProduit by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  categoryProduitService.deleteByLabel(label);
	}
	


    @ApiOperation("Finds a categoryProduit by label of superCategoryProduct")
	@GetMapping("/superCategoryProduct/label/{label}")
	public List<CategoryProduitVo> findBySuperCategoryProductLabel(@PathVariable String label){
		return categoryProduitConverter.toVo(categoryProduitService.findBySuperCategoryProductLabel(label));
	}
	
	@ApiOperation("Deletes a categoryProduit by label of superCategoryProduct")
	@DeleteMapping("/superCategoryProduct/label/{label}")
	public int deleteBySuperCategoryProductLabel(@PathVariable String label){
		return categoryProduitService.deleteBySuperCategoryProductLabel(label);
	}
	
	@ApiOperation("Finds categoryProduit by id of superCategoryProduct")
	@GetMapping("/superCategoryProduct/id/{id}")
	public List<CategoryProduitVo> findBySuperCategoryProductId(@PathVariable Long id){
		return categoryProduitConverter.toVo(categoryProduitService.findBySuperCategoryProductId(id));
	}
	@ApiOperation("Deletes categoryProduit by id of superCategoryProduct")
	@DeleteMapping("/superCategoryProduct/id/{id}")
	public int deleteBySuperCategoryProductId(@PathVariable Long id){
		return categoryProduitService.deleteBySuperCategoryProductId(id);
	}
     	
   
    @ApiOperation("Search categoryProduit by a specific criterion")
    @PostMapping("/search")
	public List<CategoryProduitVo> findByCriteria(@RequestBody CategoryProduitVo categoryProduitVo){
       return categoryProduitConverter.toVo(categoryProduitService.findByCriteria(categoryProduitVo));
	}	
	public CategoryProduitConverter getCategoryProduitConverter(){
		return categoryProduitConverter;
	}
 
	public void setCategoryProduitConverter(CategoryProduitConverter categoryProduitConverter){
		this.categoryProduitConverter=categoryProduitConverter;
	}

	public CategoryProduitService getCategoryProduitService(){
		return categoryProduitService;
	}
	public void setCategoryProduitService( CategoryProduitService categoryProduitService){
	 	this.categoryProduitService=categoryProduitService;
	}
	

}