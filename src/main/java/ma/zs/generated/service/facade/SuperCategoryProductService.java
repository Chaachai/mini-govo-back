package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.SuperCategoryProduct;
import ma.zs.generated.ws.rest.provided.vo.SuperCategoryProductVo;

public interface SuperCategoryProductService {

        /**

     * find all SuperCategoryProduct in database 
     * @return List<SuperCategoryProduct> , If database is empty return  null.
     */
	List<SuperCategoryProduct> findAll();
	   
	/**

     * find SuperCategoryProduct from database by label (reference)
     * @param label - reference of SuperCategoryProduct 
     * @return the founded SuperCategoryProduct , If no SuperCategoryProduct were
     *         found in database return  null.
     */
	SuperCategoryProduct findByLabel(String label);

    /**
     * find SuperCategoryProduct from database by id (id)
     * @param id - id of SuperCategoryProduct 
     * @return the founded  SuperCategoryProduct , If no SuperCategoryProduct were
     *         found in database return  null.
     */
	SuperCategoryProduct findById(Long id);
     
     /**
     * delete SuperCategoryProduct from database
     * @param id - id of SuperCategoryProduct to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save SuperCategoryProduct in database
     * @param superCategoryProduct - SuperCategoryProduct to be saved 
     * @return the saved SuperCategoryProduct, If the SuperCategoryProduct can't be saved return null.
     */
	SuperCategoryProduct save(SuperCategoryProduct superCategoryProduct);

	/**
     * save list SuperCategoryProduct in database
     * @param superCategoryProducts - list of SuperCategoryProduct to be saved 
     * @return the saved SuperCategoryProduct list
     */
	List<SuperCategoryProduct> save(List<SuperCategoryProduct> superCategoryProducts);
    
     /**
     * update SuperCategoryProduct in database
     * @param superCategoryProduct - SuperCategoryProduct to be updated
     * @return the updated SuperCategoryProduct, If the SuperCategoryProduct can't be updated return null.
     */
    SuperCategoryProduct update(SuperCategoryProduct superCategoryProduct);
    
       /**
     * delete SuperCategoryProduct from database
     * @param superCategoryProduct - SuperCategoryProduct to be deleted
     * @return 1 if SuperCategoryProduct deleted successfully, If the SuperCategoryProduct can't be deleted return negative int
     */
	int delete(SuperCategoryProduct superCategoryProduct);


    
        /**
     * delete SuperCategoryProduct from database by label (reference)
     * 
     * @param label - reference of SuperCategoryProduct to be deleted
     * @return 1 if SuperCategoryProduct deleted successfully
     */
	int deleteByLabel(String label);

     
	/**
     * search for SuperCategoryProduct in by some criteria
     * @return the searhed list SuperCategoryProduct 
     */
	List<SuperCategoryProduct> findByCriteria( SuperCategoryProductVo superCategoryProductVo);
}