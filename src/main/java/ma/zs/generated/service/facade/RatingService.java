package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Rating;
import ma.zs.generated.ws.rest.provided.vo.RatingVo;

public interface RatingService {

        /**

     * find all Rating in database 
     * @return List<Rating> , If database is empty return  null.
     */
	List<Rating> findAll();
	   

    /**
     * find Rating from database by id (id)
     * @param id - id of Rating 
     * @return the founded  Rating , If no Rating were
     *         found in database return  null.
     */
	Rating findById(Long id);
     
     /**
     * delete Rating from database
     * @param id - id of Rating to be deleted
     * 
     */
	void deleteById(Long id);

    List<Rating> findByClientId(Long id);
    int deleteByClientId(Long id);
			 
    List<Rating> findByOrderLineId(Long id);
    int deleteByOrderLineId(Long id);
			 
    List<Rating> findByCollaboratorId(Long id);
    int deleteByCollaboratorId(Long id);
			 
    /**
     * save Rating in database
     * @param rating - Rating to be saved 
     * @return the saved Rating, If the Rating can't be saved return null.
     */
	Rating save(Rating rating);

	/**
     * save list Rating in database
     * @param ratings - list of Rating to be saved 
     * @return the saved Rating list
     */
	List<Rating> save(List<Rating> ratings);
    
     /**
     * update Rating in database
     * @param rating - Rating to be updated
     * @return the updated Rating, If the Rating can't be updated return null.
     */
    Rating update(Rating rating);
    
       /**
     * delete Rating from database
     * @param rating - Rating to be deleted
     * @return 1 if Rating deleted successfully, If the Rating can't be deleted return negative int
     */
	int delete(Rating rating);


    

     
	/**
     * search for Rating in by some criteria
     * @return the searhed list Rating 
     */
	List<Rating> findByCriteria( RatingVo ratingVo);
}