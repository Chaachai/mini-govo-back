package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Comment;
import ma.zs.generated.ws.rest.provided.vo.CommentVo;

public interface CommentService {

        /**

     * find all Comment in database 
     * @return List<Comment> , If database is empty return  null.
     */
	List<Comment> findAll();
	   

    /**
     * find Comment from database by id (id)
     * @param id - id of Comment 
     * @return the founded  Comment , If no Comment were
     *         found in database return  null.
     */
	Comment findById(Long id);
     
     /**
     * delete Comment from database
     * @param id - id of Comment to be deleted
     * 
     */
	void deleteById(Long id);

    List<Comment> findByUserId(Long id);
    int deleteByUserId(Long id);
			 
	List<Comment> findByCommandReference(String reference);
    int deleteByCommandReference(String reference);       
			
    List<Comment> findByCommandId(Long id);
    int deleteByCommandId(Long id);
			 
    /**
     * save Comment in database
     * @param comment - Comment to be saved 
     * @return the saved Comment, If the Comment can't be saved return null.
     */
	Comment save(Comment comment);

	/**
     * save list Comment in database
     * @param comments - list of Comment to be saved 
     * @return the saved Comment list
     */
	List<Comment> save(List<Comment> comments);
    
     /**
     * update Comment in database
     * @param comment - Comment to be updated
     * @return the updated Comment, If the Comment can't be updated return null.
     */
    Comment update(Comment comment);
    
       /**
     * delete Comment from database
     * @param comment - Comment to be deleted
     * @return 1 if Comment deleted successfully, If the Comment can't be deleted return negative int
     */
	int delete(Comment comment);


    

     
	/**
     * search for Comment in by some criteria
     * @return the searhed list Comment 
     */
	List<Comment> findByCriteria( CommentVo commentVo);
}