package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.SuperOrderStatus;
import ma.zs.generated.ws.rest.provided.vo.SuperOrderStatusVo;

public interface SuperOrderStatusService {

        /**

     * find all SuperOrderStatus in database 
     * @return List<SuperOrderStatus> , If database is empty return  null.
     */
	List<SuperOrderStatus> findAll();
	   
	/**

     * find SuperOrderStatus from database by code (reference)
     * @param code - reference of SuperOrderStatus 
     * @return the founded SuperOrderStatus , If no SuperOrderStatus were
     *         found in database return  null.
     */
	SuperOrderStatus findByCode(String code);

    /**
     * find SuperOrderStatus from database by id (id)
     * @param id - id of SuperOrderStatus 
     * @return the founded  SuperOrderStatus , If no SuperOrderStatus were
     *         found in database return  null.
     */
	SuperOrderStatus findById(Long id);
     
     /**
     * delete SuperOrderStatus from database
     * @param id - id of SuperOrderStatus to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save SuperOrderStatus in database
     * @param superOrderStatus - SuperOrderStatus to be saved 
     * @return the saved SuperOrderStatus, If the SuperOrderStatus can't be saved return null.
     */
	SuperOrderStatus save(SuperOrderStatus superOrderStatus);

	/**
     * save list SuperOrderStatus in database
     * @param superOrderStatuss - list of SuperOrderStatus to be saved 
     * @return the saved SuperOrderStatus list
     */
	List<SuperOrderStatus> save(List<SuperOrderStatus> superOrderStatuss);
    
     /**
     * update SuperOrderStatus in database
     * @param superOrderStatus - SuperOrderStatus to be updated
     * @return the updated SuperOrderStatus, If the SuperOrderStatus can't be updated return null.
     */
    SuperOrderStatus update(SuperOrderStatus superOrderStatus);
    
       /**
     * delete SuperOrderStatus from database
     * @param superOrderStatus - SuperOrderStatus to be deleted
     * @return 1 if SuperOrderStatus deleted successfully, If the SuperOrderStatus can't be deleted return negative int
     */
	int delete(SuperOrderStatus superOrderStatus);


    
        /**
     * delete SuperOrderStatus from database by code (reference)
     * 
     * @param code - reference of SuperOrderStatus to be deleted
     * @return 1 if SuperOrderStatus deleted successfully
     */
	int deleteByCode(String code);

     
	/**
     * search for SuperOrderStatus in by some criteria
     * @return the searhed list SuperOrderStatus 
     */
	List<SuperOrderStatus> findByCriteria( SuperOrderStatusVo superOrderStatusVo);
}