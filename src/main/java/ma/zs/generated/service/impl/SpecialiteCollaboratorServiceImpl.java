package ma.zs.generated.service.impl;

import ma.zs.generated.bean.SpecialiteCollaborator;
import ma.zs.generated.dao.SpecialiteCollaboratorDao;
import ma.zs.generated.service.facade.SpecialiteCollaboratorService;
import ma.zs.generated.service.util.SearchUtil;
import ma.zs.generated.ws.rest.provided.vo.SpecialiteCollaboratorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialiteCollaboratorServiceImpl implements SpecialiteCollaboratorService {

    @Autowired
    private SpecialiteCollaboratorDao specialiteCollaboratorDao;


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<SpecialiteCollaborator> findAll() {
        return specialiteCollaboratorDao.findAll();
    }

    @Override
    public SpecialiteCollaborator findById(Long id) {
        if (id == null)
            return null;
        return specialiteCollaboratorDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        specialiteCollaboratorDao.deleteById(id);
    }

    @Override
    public SpecialiteCollaborator save(SpecialiteCollaborator specialiteCollaborator) {
        return specialiteCollaboratorDao.save(specialiteCollaborator);
    }

    @Override
    public List<SpecialiteCollaborator> save(List<SpecialiteCollaborator> specialiteCollaborators) {
        List<SpecialiteCollaborator> list = new ArrayList<>();
        for (SpecialiteCollaborator specialiteCollaborator : specialiteCollaborators) {
            list.add(save(specialiteCollaborator));
        }
        return list;
    }


    @Override
    public SpecialiteCollaborator update(SpecialiteCollaborator specialiteCollaborator) {


        SpecialiteCollaborator foundedSpecialiteCollaborator = findById(specialiteCollaborator.getId());
        if (foundedSpecialiteCollaborator == null)
            return null;

        return specialiteCollaboratorDao.save(specialiteCollaborator);

    }

    @Override
    @Transactional
    public int delete(SpecialiteCollaborator specialiteCollaborator) {

        if (specialiteCollaborator.getId() == null)
            return -1;
        SpecialiteCollaborator foundedSpecialiteCollaborator = findById(specialiteCollaborator.getId());
        if (foundedSpecialiteCollaborator == null)
            return -1;
        specialiteCollaboratorDao.delete(foundedSpecialiteCollaborator);
        return 1;
    }


    public List<SpecialiteCollaborator> findByCriteria(SpecialiteCollaboratorVo specialiteCollaboratorVo) {
        String query = "SELECT o FROM SpecialiteCollaborator o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", specialiteCollaboratorVo.getId());

        return entityManager.createQuery(query).getResultList();
    }


}
