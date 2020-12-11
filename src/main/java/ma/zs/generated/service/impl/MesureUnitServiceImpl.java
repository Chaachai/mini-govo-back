package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.MesureUnit;
import ma.zs.generated.dao.MesureUnitDao;
import ma.zs.generated.service.facade.MesureUnitService;

import ma.zs.generated.ws.rest.provided.vo.MesureUnitVo;
import ma.zs.generated.service.util.*;
@Service
public class MesureUnitServiceImpl implements MesureUnitService {

   @Autowired
   private MesureUnitDao mesureUnitDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<MesureUnit> findAll(){
		return mesureUnitDao.findAll();
	}	
	@Override
	public MesureUnit findByLabel(String label){
		if( label==null)
		  return null;
		return mesureUnitDao.findByLabel(label);
	}

   

	@Override
	@Transactional
	public int deleteByLabel(String  label) {
		return mesureUnitDao.deleteByLabel(label);	 
	}

	@Override
	public MesureUnit findById(Long id){
		 if(id==null)
		  return null;
		return mesureUnitDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           mesureUnitDao.deleteById(id);
   }
	@Override	
	public MesureUnit save (MesureUnit mesureUnit){
			MesureUnit foundedMesureUnit = findByLabel(mesureUnit.getLabel());
	       if(foundedMesureUnit!=null)
	          return null;  

	    MesureUnit savedMesureUnit = mesureUnitDao.save(mesureUnit);
	   return savedMesureUnit;
	}

    @Override
    public List<MesureUnit> save(List<MesureUnit> mesureUnits){
		List<MesureUnit> list = new ArrayList<MesureUnit>();
		for(MesureUnit mesureUnit: mesureUnits){
		        list.add(save(mesureUnit));	
		}
		return list;
	}


   @Override
   public MesureUnit update(MesureUnit mesureUnit){
     
    
		  MesureUnit foundedMesureUnit = findById(mesureUnit.getId()); 
		       if(foundedMesureUnit==null)
	          return null;	  
	  
	   return  mesureUnitDao.save(mesureUnit);
     
     }
    
	@Override
	@Transactional
	public int delete(MesureUnit mesureUnit){

	        if(mesureUnit.getLabel()==null)
			  return -1;
		
			MesureUnit foundedMesureUnit = findByLabel(mesureUnit.getLabel());
	       if(foundedMesureUnit==null)
	          return -1;  
	   mesureUnitDao.delete(foundedMesureUnit);
	   return 1;
	}


	public List<MesureUnit> findByCriteria(MesureUnitVo mesureUnitVo){
      String query = "SELECT o FROM MesureUnit o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "label","LIKE",mesureUnitVo.getLabel());

		 	 query += SearchUtil.addConstraint( "o", "id","=",mesureUnitVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
