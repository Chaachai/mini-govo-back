package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.PricingCollaborator;
import ma.zs.generated.dao.PricingCollaboratorDao;
import ma.zs.generated.service.facade.PricingCollaboratorService;

import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;
import ma.zs.generated.service.util.*;
@Service
public class PricingCollaboratorServiceImpl implements PricingCollaboratorService {

   @Autowired
   private PricingCollaboratorDao pricingCollaboratorDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<PricingCollaborator> findAll(){
		return pricingCollaboratorDao.findAll();
	}	

	@Override
	public PricingCollaborator findById(Long id){
		 if(id==null)
		  return null;
		return pricingCollaboratorDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           pricingCollaboratorDao.deleteById(id);
   }
	@Override	
	public PricingCollaborator save (PricingCollaborator pricingCollaborator){

	    PricingCollaborator savedPricingCollaborator = pricingCollaboratorDao.save(pricingCollaborator);
	   return savedPricingCollaborator;
	}

    @Override
    public List<PricingCollaborator> save(List<PricingCollaborator> pricingCollaborators){
		List<PricingCollaborator> list = new ArrayList<PricingCollaborator>();
		for(PricingCollaborator pricingCollaborator: pricingCollaborators){
		        list.add(save(pricingCollaborator));	
		}
		return list;
	}


   @Override
   public PricingCollaborator update(PricingCollaborator pricingCollaborator){
     
    
		  PricingCollaborator foundedPricingCollaborator = findById(pricingCollaborator.getId()); 
		       if(foundedPricingCollaborator==null)
	          return null;	  
	  
	   return  pricingCollaboratorDao.save(pricingCollaborator);
     
     }
    
	@Override
	@Transactional
	public int delete(PricingCollaborator pricingCollaborator){

		 if(pricingCollaborator.getId()==null)
			  return -1;
		  PricingCollaborator foundedPricingCollaborator = findById(pricingCollaborator.getId()); 
		       if(foundedPricingCollaborator==null)
	          return -1;	  
	   pricingCollaboratorDao.delete(foundedPricingCollaborator);
	   return 1;
	}


	public List<PricingCollaborator> findByCriteria(PricingCollaboratorVo pricingCollaboratorVo){
      String query = "SELECT o FROM PricingCollaborator o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "priceMax","=",pricingCollaboratorVo.getPriceMax());
		 	 query += SearchUtil.addConstraint( "o", "price","=",pricingCollaboratorVo.getPrice());
		 	 query += SearchUtil.addConstraint( "o", "priceMin","=",pricingCollaboratorVo.getPriceMin());
		 	 query += SearchUtil.addConstraint( "o", "id","=",pricingCollaboratorVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","priceMax",pricingCollaboratorVo.getPriceMaxMin(),pricingCollaboratorVo.getPriceMaxMax());
	  query += SearchUtil.addConstraintMinMax("o","price",pricingCollaboratorVo.getPriceMin(),pricingCollaboratorVo.getPriceMax());
	  query += SearchUtil.addConstraintMinMax("o","priceMin",pricingCollaboratorVo.getPriceMinMin(),pricingCollaboratorVo.getPriceMinMax());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
