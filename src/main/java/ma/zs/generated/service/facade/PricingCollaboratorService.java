package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.PricingCollaborator;
import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;

public interface PricingCollaboratorService {

        /**

     * find all PricingCollaborator in database 
     * @return List<PricingCollaborator> , If database is empty return  null.
     */
	List<PricingCollaborator> findAll();
	   

    /**
     * find PricingCollaborator from database by id (id)
     * @param id - id of PricingCollaborator 
     * @return the founded  PricingCollaborator , If no PricingCollaborator were
     *         found in database return  null.
     */
	PricingCollaborator findById(Long id);
     
     /**
     * delete PricingCollaborator from database
     * @param id - id of PricingCollaborator to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save PricingCollaborator in database
     * @param pricingCollaborator - PricingCollaborator to be saved 
     * @return the saved PricingCollaborator, If the PricingCollaborator can't be saved return null.
     */
	PricingCollaborator save(PricingCollaborator pricingCollaborator);

	/**
     * save list PricingCollaborator in database
     * @param pricingCollaborators - list of PricingCollaborator to be saved 
     * @return the saved PricingCollaborator list
     */
	List<PricingCollaborator> save(List<PricingCollaborator> pricingCollaborators);
    
     /**
     * update PricingCollaborator in database
     * @param pricingCollaborator - PricingCollaborator to be updated
     * @return the updated PricingCollaborator, If the PricingCollaborator can't be updated return null.
     */
    PricingCollaborator update(PricingCollaborator pricingCollaborator);
    
       /**
     * delete PricingCollaborator from database
     * @param pricingCollaborator - PricingCollaborator to be deleted
     * @return 1 if PricingCollaborator deleted successfully, If the PricingCollaborator can't be deleted return negative int
     */
	int delete(PricingCollaborator pricingCollaborator);


    

     
	/**
     * search for PricingCollaborator in by some criteria
     * @return the searhed list PricingCollaborator 
     */
	List<PricingCollaborator> findByCriteria( PricingCollaboratorVo pricingCollaboratorVo);
}