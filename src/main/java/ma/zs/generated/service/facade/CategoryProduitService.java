package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.CategoryProduit;
import ma.zs.generated.ws.rest.provided.vo.CategoryProduitVo;

public interface CategoryProduitService {

        /**

     * find all CategoryProduit in database 
     * @return List<CategoryProduit> , If database is empty return  null.
     */
	List<CategoryProduit> findAll();
	   
	/**

     * find CategoryProduit from database by label (reference)
     * @param label - reference of CategoryProduit 
     * @return the founded CategoryProduit , If no CategoryProduit were
     *         found in database return  null.
     */
	CategoryProduit findByLabel(String label);

    /**
     * find CategoryProduit from database by id (id)
     * @param id - id of CategoryProduit 
     * @return the founded  CategoryProduit , If no CategoryProduit were
     *         found in database return  null.
     */
	CategoryProduit findById(Long id);
     
     /**
     * delete CategoryProduit from database
     * @param id - id of CategoryProduit to be deleted
     * 
     */
	void deleteById(Long id);

	List<CategoryProduit> findBySuperCategoryProductLabel(String label);
    int deleteBySuperCategoryProductLabel(String label);       
			
    List<CategoryProduit> findBySuperCategoryProductId(Long id);
    int deleteBySuperCategoryProductId(Long id);
			 
    /**
     * save CategoryProduit in database
     * @param categoryProduit - CategoryProduit to be saved 
     * @return the saved CategoryProduit, If the CategoryProduit can't be saved return null.
     */
	CategoryProduit save(CategoryProduit categoryProduit);

	/**
     * save list CategoryProduit in database
     * @param categoryProduits - list of CategoryProduit to be saved 
     * @return the saved CategoryProduit list
     */
	List<CategoryProduit> save(List<CategoryProduit> categoryProduits);
    
     /**
     * update CategoryProduit in database
     * @param categoryProduit - CategoryProduit to be updated
     * @return the updated CategoryProduit, If the CategoryProduit can't be updated return null.
     */
    CategoryProduit update(CategoryProduit categoryProduit);
    
       /**
     * delete CategoryProduit from database
     * @param categoryProduit - CategoryProduit to be deleted
     * @return 1 if CategoryProduit deleted successfully, If the CategoryProduit can't be deleted return negative int
     */
	int delete(CategoryProduit categoryProduit);


    
        /**
     * delete CategoryProduit from database by label (reference)
     * 
     * @param label - reference of CategoryProduit to be deleted
     * @return 1 if CategoryProduit deleted successfully
     */
	int deleteByLabel(String label);

     
	/**
     * search for CategoryProduit in by some criteria
     * @return the searhed list CategoryProduit 
     */
	List<CategoryProduit> findByCriteria( CategoryProduitVo categoryProduitVo);
}