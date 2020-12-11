package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Rating;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.RatingDao;
import ma.zs.generated.service.facade.RatingService;
import ma.zs.generated.service.facade.UserService;   
import ma.zs.generated.service.facade.OrderLineService;   

import ma.zs.generated.ws.rest.provided.vo.RatingVo;
import ma.zs.generated.service.util.*;
@Service
public class RatingServiceImpl implements RatingService {

   @Autowired
   private RatingDao ratingDao;
   
    @Autowired
    private UserService userService ;
    @Autowired
    private OrderLineService orderLineService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Rating> findAll(){
		return ratingDao.findAll();
	}	
     @Override
    public List<Rating> findByClientId(Long id){
		return ratingDao.findByClientId(id);

	}
	   @Override
	   @Transactional
    public int deleteByClientId(Long id){
		return ratingDao.deleteByClientId(id);

	}
     		
     @Override
    public List<Rating> findByOrderLineId(Long id){
		return ratingDao.findByOrderLineId(id);

	}
	   @Override
	   @Transactional
    public int deleteByOrderLineId(Long id){
		return ratingDao.deleteByOrderLineId(id);

	}
     		
     @Override
    public List<Rating> findByCollaboratorId(Long id){
		return ratingDao.findByCollaboratorId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCollaboratorId(Long id){
		return ratingDao.deleteByCollaboratorId(id);

	}
     		

	@Override
	public Rating findById(Long id){
		 if(id==null)
		  return null;
		return ratingDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           ratingDao.deleteById(id);
   }
	@Override	
	public Rating save (Rating rating){
	    
	          if(rating.getClient()!=null){
                      User client = userService.findById(rating.getClient().getId());
				  
				  if(client == null)
				  rating.setClient(userService.save(rating.getClient()));
				  else
				  rating.setClient(client);
			  }
	    
	          if(rating.getOrderLine()!=null){
                      OrderLine orderLine = orderLineService.findById(rating.getOrderLine().getId());
				  
				  if(orderLine == null)
				  rating.setOrderLine(orderLineService.save(rating.getOrderLine()));
				  else
				  rating.setOrderLine(orderLine);
			  }
	    
	          if(rating.getCollaborator()!=null){
                      User collaborator = userService.findById(rating.getCollaborator().getId());
				  
				  if(collaborator == null)
				  rating.setCollaborator(userService.save(rating.getCollaborator()));
				  else
				  rating.setCollaborator(collaborator);
			  }

	    Rating savedRating = ratingDao.save(rating);
	   return savedRating;
	}

    @Override
    public List<Rating> save(List<Rating> ratings){
		List<Rating> list = new ArrayList<Rating>();
		for(Rating rating: ratings){
		        list.add(save(rating));	
		}
		return list;
	}


   @Override
   public Rating update(Rating rating){
     
    
		  Rating foundedRating = findById(rating.getId()); 
		       if(foundedRating==null)
	          return null;	  
	  
	   return  ratingDao.save(rating);
     
     }
    
	@Override
	@Transactional
	public int delete(Rating rating){

		 if(rating.getId()==null)
			  return -1;
		  Rating foundedRating = findById(rating.getId()); 
		       if(foundedRating==null)
	          return -1;	  
	   ratingDao.delete(foundedRating);
	   return 1;
	}


	public List<Rating> findByCriteria(RatingVo ratingVo){
      String query = "SELECT o FROM Rating o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "comment","LIKE",ratingVo.getComment());

		 	 query += SearchUtil.addConstraint( "o", "mark","=",ratingVo.getMark());
		 	 query += SearchUtil.addConstraint( "o", "id","=",ratingVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","mark",ratingVo.getMarkMin(),ratingVo.getMarkMax());
   if(ratingVo.getClientVo()!=null){
     query += SearchUtil.addConstraint( "o", "client.id","=",ratingVo.getClientVo().getId());
   }
   
   if(ratingVo.getOrderLineVo()!=null){
     query += SearchUtil.addConstraint( "o", "orderLine.id","=",ratingVo.getOrderLineVo().getId());
   }
   
   if(ratingVo.getCollaboratorVo()!=null){
     query += SearchUtil.addConstraint( "o", "collaborator.id","=",ratingVo.getCollaboratorVo().getId());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
