package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;

public interface OrderStatusService {

        /**

     * find all OrderStatus in database 
     * @return List<OrderStatus> , If database is empty return  null.
     */
	List<OrderStatus> findAll();
	   
	/**

     * find OrderStatus from database by code (reference)
     * @param code - reference of OrderStatus 
     * @return the founded OrderStatus , If no OrderStatus were
     *         found in database return  null.
     */
	OrderStatus findByCode(String code);

    /**
     * find OrderStatus from database by id (id)
     * @param id - id of OrderStatus 
     * @return the founded  OrderStatus , If no OrderStatus were
     *         found in database return  null.
     */
	OrderStatus findById(Long id);
     
     /**
     * delete OrderStatus from database
     * @param id - id of OrderStatus to be deleted
     * 
     */
	void deleteById(Long id);

	List<OrderStatus> findBySuperOrderStatusCode(String code);
    int deleteBySuperOrderStatusCode(String code);       
			
    List<OrderStatus> findBySuperOrderStatusId(Long id);
    int deleteBySuperOrderStatusId(Long id);
			 
    /**
     * save OrderStatus in database
     * @param orderStatus - OrderStatus to be saved 
     * @return the saved OrderStatus, If the OrderStatus can't be saved return null.
     */
	OrderStatus save(OrderStatus orderStatus);

	/**
     * save list OrderStatus in database
     * @param orderStatuss - list of OrderStatus to be saved 
     * @return the saved OrderStatus list
     */
	List<OrderStatus> save(List<OrderStatus> orderStatuss);
    
     /**
     * update OrderStatus in database
     * @param orderStatus - OrderStatus to be updated
     * @return the updated OrderStatus, If the OrderStatus can't be updated return null.
     */
    OrderStatus update(OrderStatus orderStatus);
    
       /**
     * delete OrderStatus from database
     * @param orderStatus - OrderStatus to be deleted
     * @return 1 if OrderStatus deleted successfully, If the OrderStatus can't be deleted return negative int
     */
	int delete(OrderStatus orderStatus);


    
        /**
     * delete OrderStatus from database by code (reference)
     * 
     * @param code - reference of OrderStatus to be deleted
     * @return 1 if OrderStatus deleted successfully
     */
	int deleteByCode(String code);

     
	/**
     * search for OrderStatus in by some criteria
     * @return the searhed list OrderStatus 
     */
	List<OrderStatus> findByCriteria( OrderStatusVo orderStatusVo);
}