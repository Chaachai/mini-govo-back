package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.MesureUnit;
import ma.zs.generated.ws.rest.provided.vo.MesureUnitVo;

public interface MesureUnitService {

        /**

     * find all MesureUnit in database 
     * @return List<MesureUnit> , If database is empty return  null.
     */
	List<MesureUnit> findAll();
	   
	/**

     * find MesureUnit from database by label (reference)
     * @param label - reference of MesureUnit 
     * @return the founded MesureUnit , If no MesureUnit were
     *         found in database return  null.
     */
	MesureUnit findByLabel(String label);

    /**
     * find MesureUnit from database by id (id)
     * @param id - id of MesureUnit 
     * @return the founded  MesureUnit , If no MesureUnit were
     *         found in database return  null.
     */
	MesureUnit findById(Long id);
     
     /**
     * delete MesureUnit from database
     * @param id - id of MesureUnit to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save MesureUnit in database
     * @param mesureUnit - MesureUnit to be saved 
     * @return the saved MesureUnit, If the MesureUnit can't be saved return null.
     */
	MesureUnit save(MesureUnit mesureUnit);

	/**
     * save list MesureUnit in database
     * @param mesureUnits - list of MesureUnit to be saved 
     * @return the saved MesureUnit list
     */
	List<MesureUnit> save(List<MesureUnit> mesureUnits);
    
     /**
     * update MesureUnit in database
     * @param mesureUnit - MesureUnit to be updated
     * @return the updated MesureUnit, If the MesureUnit can't be updated return null.
     */
    MesureUnit update(MesureUnit mesureUnit);
    
       /**
     * delete MesureUnit from database
     * @param mesureUnit - MesureUnit to be deleted
     * @return 1 if MesureUnit deleted successfully, If the MesureUnit can't be deleted return negative int
     */
	int delete(MesureUnit mesureUnit);


    
        /**
     * delete MesureUnit from database by label (reference)
     * 
     * @param label - reference of MesureUnit to be deleted
     * @return 1 if MesureUnit deleted successfully
     */
	int deleteByLabel(String label);

     
	/**
     * search for MesureUnit in by some criteria
     * @return the searhed list MesureUnit 
     */
	List<MesureUnit> findByCriteria( MesureUnitVo mesureUnitVo);
}