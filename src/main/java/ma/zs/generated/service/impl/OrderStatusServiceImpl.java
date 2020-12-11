package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.SuperOrderStatus;
import ma.zs.generated.dao.OrderStatusDao;
import ma.zs.generated.service.facade.OrderStatusService;
import ma.zs.generated.service.facade.SuperOrderStatusService;   

import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;
import ma.zs.generated.service.util.*;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

   @Autowired
   private OrderStatusDao orderStatusDao;
   
    @Autowired
    private SuperOrderStatusService superOrderStatusService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<OrderStatus> findAll(){
		return orderStatusDao.findAll();
	}	
	@Override
	public List<OrderStatus> findBySuperOrderStatusCode(String code){
		return orderStatusDao.findBySuperOrderStatusCode(code);
	}
	@Override
	@Transactional
    public int deleteBySuperOrderStatusCode(String code){
		return orderStatusDao.deleteBySuperOrderStatusCode(code);
	}
	
     @Override
    public List<OrderStatus> findBySuperOrderStatusId(Long id){
		return orderStatusDao.findBySuperOrderStatusId(id);

	}
	   @Override
	   @Transactional
    public int deleteBySuperOrderStatusId(Long id){
		return orderStatusDao.deleteBySuperOrderStatusId(id);

	}
     		
	@Override
	public OrderStatus findByCode(String code){
		if( code==null)
		  return null;
		return orderStatusDao.findByCode(code);
	}

   

	@Override
	@Transactional
	public int deleteByCode(String  code) {
		return orderStatusDao.deleteByCode(code);	 
	}

	@Override
	public OrderStatus findById(Long id){
		 if(id==null)
		  return null;
		return orderStatusDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           orderStatusDao.deleteById(id);
   }
	@Override	
	public OrderStatus save (OrderStatus orderStatus){
			OrderStatus foundedOrderStatus = findByCode(orderStatus.getCode());
	       if(foundedOrderStatus!=null)
	          return null;  
	    
	          if(orderStatus.getSuperOrderStatus()!=null){
				    SuperOrderStatus superOrderStatus = superOrderStatusService.findByCode(orderStatus.getSuperOrderStatus().getCode());
				  if(superOrderStatus == null)
				  orderStatus.setSuperOrderStatus(superOrderStatusService.save(orderStatus.getSuperOrderStatus()));
				  else
				  orderStatus.setSuperOrderStatus(superOrderStatus);
			  }

	    OrderStatus savedOrderStatus = orderStatusDao.save(orderStatus);
	   return savedOrderStatus;
	}

    @Override
    public List<OrderStatus> save(List<OrderStatus> orderStatuss){
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		for(OrderStatus orderStatus: orderStatuss){
		        list.add(save(orderStatus));	
		}
		return list;
	}


   @Override
   public OrderStatus update(OrderStatus orderStatus){
     
    
		  OrderStatus foundedOrderStatus = findById(orderStatus.getId()); 
		       if(foundedOrderStatus==null)
	          return null;	  
	  
	   return  orderStatusDao.save(orderStatus);
     
     }
    
	@Override
	@Transactional
	public int delete(OrderStatus orderStatus){

	        if(orderStatus.getCode()==null)
			  return -1;
		
			OrderStatus foundedOrderStatus = findByCode(orderStatus.getCode());
	       if(foundedOrderStatus==null)
	          return -1;  
	   orderStatusDao.delete(foundedOrderStatus);
	   return 1;
	}


	public List<OrderStatus> findByCriteria(OrderStatusVo orderStatusVo){
      String query = "SELECT o FROM OrderStatus o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "label","LIKE",orderStatusVo.getLabel());

			 query += SearchUtil.addConstraint( "o", "color ","LIKE",orderStatusVo.getColor ());

		 	 query += SearchUtil.addConstraint( "o", "id","=",orderStatusVo.getId());
			 query += SearchUtil.addConstraint( "o", "code","LIKE",orderStatusVo.getCode());

   if(orderStatusVo.getSuperOrderStatusVo()!=null){
     query += SearchUtil.addConstraint( "o", "superOrderStatus.id","=",orderStatusVo.getSuperOrderStatusVo().getId());
     query += SearchUtil.addConstraint( "o", "superOrderStatus.code","LIKE",orderStatusVo.getSuperOrderStatusVo().getCode());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
