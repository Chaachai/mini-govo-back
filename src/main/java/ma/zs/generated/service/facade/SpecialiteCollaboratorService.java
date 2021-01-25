package ma.zs.generated.service.facade;

import ma.zs.generated.bean.SpecialiteCollaborator;
import ma.zs.generated.ws.rest.provided.vo.SpecialiteCollaboratorVo;

import java.util.List;

public interface SpecialiteCollaboratorService {

    /**
     * find all SpecialiteCollaborator in database
     *
     * @return List<SpecialiteCollaborator> , If database is empty return  null.
     */
    List<SpecialiteCollaborator> findAll();


    /**
     * find SpecialiteCollaborator from database by id (id)
     *
     * @param id - id of SpecialiteCollaborator
     * @return the founded  SpecialiteCollaborator , If no SpecialiteCollaborator were
     * found in database return  null.
     */
    SpecialiteCollaborator findById(Long id);

    /**
     * delete SpecialiteCollaborator from database
     *
     * @param id - id of SpecialiteCollaborator to be deleted
     */
    void deleteById(Long id);

    /**
     * save SpecialiteCollaborator in database
     *
     * @param specialiteCollaborator - SpecialiteCollaborator to be saved
     * @return the saved SpecialiteCollaborator, If the SpecialiteCollaborator can't be saved return null.
     */
    SpecialiteCollaborator save(SpecialiteCollaborator specialiteCollaborator);

    /**
     * save list SpecialiteCollaborator in database
     *
     * @param specialiteCollaborators - list of SpecialiteCollaborator to be saved
     * @return the saved SpecialiteCollaborator list
     */
    List<SpecialiteCollaborator> save(List<SpecialiteCollaborator> specialiteCollaborators);

    /**
     * update SpecialiteCollaborator in database
     *
     * @param specialiteCollaborator - SpecialiteCollaborator to be updated
     * @return the updated SpecialiteCollaborator, If the SpecialiteCollaborator can't be updated return null.
     */
    SpecialiteCollaborator update(SpecialiteCollaborator specialiteCollaborator);

    /**
     * delete SpecialiteCollaborator from database
     *
     * @param specialiteCollaborator - SpecialiteCollaborator to be deleted
     * @return 1 if SpecialiteCollaborator deleted successfully, If the SpecialiteCollaborator can't be deleted return negative int
     */
    int delete(SpecialiteCollaborator specialiteCollaborator);


    /**
     * search for SpecialiteCollaborator in by some criteria
     *
     * @return the searhed list SpecialiteCollaborator
     */
    List<SpecialiteCollaborator> findByCriteria(SpecialiteCollaboratorVo specialiteCollaboratorVo);
}