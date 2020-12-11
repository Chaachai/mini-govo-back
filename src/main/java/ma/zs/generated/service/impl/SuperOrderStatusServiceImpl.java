package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.SuperOrderStatus;
import ma.zs.generated.dao.SuperOrderStatusDao;
import ma.zs.generated.service.facade.SuperOrderStatusService;

import ma.zs.generated.ws.rest.provided.vo.SuperOrderStatusVo;
import ma.zs.generated.service.util.*;
@Service
public class SuperOrderStatusServiceImpl implements SuperOrderStatusService {

   @Autowired
   private SuperOrderStatusDao superOrderStatusDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<SuperOrderStatus> findAll(){
		return superOrderStatusDao.findAll();
	}	
	@Override
	public SuperOrderStatus findByCode(String code){
		if( code==null)
		  return null;
		return superOrderStatusDao.findByCode(code);
	}

   

	@Override
	@Transactional
	public int deleteByCode(String  code) {
		return superOrderStatusDao.deleteByCode(code);	 
	}

	@Override
	public SuperOrderStatus findById(Long id){
		 if(id==null)
		  return null;
		return superOrderStatusDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           superOrderStatusDao.deleteById(id);
   }
	@Override	
	public SuperOrderStatus save (SuperOrderStatus superOrderStatus){
			SuperOrderStatus foundedSuperOrderStatus = findByCode(superOrderStatus.getCode());
	       if(foundedSuperOrderStatus!=null)
	          return null;  

	    SuperOrderStatus savedSuperOrderStatus = superOrderStatusDao.save(superOrderStatus);
	   return savedSuperOrderStatus;
	}

    @Override
    public List<SuperOrderStatus> save(List<SuperOrderStatus> superOrderStatuss){
		List<SuperOrderStatus> list = new ArrayList<SuperOrderStatus>();
		for(SuperOrderStatus superOrderStatus: superOrderStatuss){
		        list.add(save(superOrderStatus));	
		}
		return list;
	}


   @Override
   public SuperOrderStatus update(SuperOrderStatus superOrderStatus){
     
    
		  SuperOrderStatus foundedSuperOrderStatus = findById(superOrderStatus.getId()); 
		       if(foundedSuperOrderStatus==null)
	          return null;	  
	  
	   return  superOrderStatusDao.save(superOrderStatus);
     
     }
    
	@Override
	@Transactional
	public int delete(SuperOrderStatus superOrderStatus){

	        if(superOrderStatus.getCode()==null)
			  return -1;
		
			SuperOrderStatus foundedSuperOrderStatus = findByCode(superOrderStatus.getCode());
	       if(foundedSuperOrderStatus==null)
	          return -1;  
	   superOrderStatusDao.delete(foundedSuperOrderStatus);
	   return 1;
	}


	public List<SuperOrderStatus> findByCriteria(SuperOrderStatusVo superOrderStatusVo){
      String query = "SELECT o FROM SuperOrderStatus o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "color","LIKE",superOrderStatusVo.getColor());

			 query += SearchUtil.addConstraint( "o", "label","LIKE",superOrderStatusVo.getLabel());

			 query += SearchUtil.addConstraint( "o", "code","LIKE",superOrderStatusVo.getCode());

		 	 query += SearchUtil.addConstraint( "o", "id","=",superOrderStatusVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
