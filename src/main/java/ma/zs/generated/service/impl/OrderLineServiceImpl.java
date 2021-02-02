package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.Product;
import ma.zs.generated.dao.OrderLineDao;
import ma.zs.generated.service.facade.OrderLineService;
import ma.zs.generated.service.facade.UserService;   
import ma.zs.generated.service.facade.CommandService;   
import ma.zs.generated.service.facade.ProductService;   
import ma.zs.generated.service.facade.OrderStatusService;   

import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;
import ma.zs.generated.service.util.*;
@Service
public class OrderLineServiceImpl implements OrderLineService {

   @Autowired
   private OrderLineDao orderLineDao;
   
    @Autowired
    private UserService userService ;
    @Autowired
    private CommandService commandService ;
    @Autowired
    private ProductService productService ;
    @Autowired
    private OrderStatusService orderStatusService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<OrderLine> findAll(){
		return orderLineDao.findAll();
	}	
	@Override
	public List<OrderLine> findByOrderStatusCode(String code){
		return orderLineDao.findByOrderStatusCode(code);
	}
	@Override
	@Transactional
    public int deleteByOrderStatusCode(String code){
		return orderLineDao.deleteByOrderStatusCode(code);
	}
	
     @Override
    public List<OrderLine> findByOrderStatusId(Long id){
		return orderLineDao.findByOrderStatusId(id);

	}
	   @Override
	   @Transactional
    public int deleteByOrderStatusId(Long id){
		return orderLineDao.deleteByOrderStatusId(id);

	}
     		
     @Override
    public List<OrderLine> findByDeliveryManId(Long id){
		return orderLineDao.findByDeliveryManId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDeliveryManId(Long id){
		return orderLineDao.deleteByDeliveryManId(id);

	}
     		
     @Override
    public List<OrderLine> findByCollaboratorId(Long id){
		return orderLineDao.findByCollaboratorId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCollaboratorId(Long id){
		return orderLineDao.deleteByCollaboratorId(id);

	}
     		
	@Override
	public List<OrderLine> findByCommandReference(String reference){
		return orderLineDao.findByCommandReference(reference);
	}
	@Override
	@Transactional
    public int deleteByCommandReference(String reference){
		return orderLineDao.deleteByCommandReference(reference);
	}
	
     @Override
    public List<OrderLine> findByCommandId(Long id){
		return orderLineDao.findByCommandId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCommandId(Long id){
		return orderLineDao.deleteByCommandId(id);

	}
     		
	@Override
	public List<OrderLine> findByProductReference(String reference){
		return orderLineDao.findByProductReference(reference);
	}
	@Override
	@Transactional
    public int deleteByProductReference(String reference){
		return orderLineDao.deleteByProductReference(reference);
	}
	
     @Override
    public List<OrderLine> findByProductId(Long id){
		return orderLineDao.findByProductId(id);

	}
	   @Override
	   @Transactional
    public int deleteByProductId(Long id){
		return orderLineDao.deleteByProductId(id);

	}
     		

	@Override
	public OrderLine findById(Long id){
		 if(id==null)
		  return null;
		return orderLineDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           orderLineDao.deleteById(id);
   }
	@Override	
	public OrderLine save (OrderLine orderLine){
	    
	          if(orderLine.getOrderStatus ()!=null){
				    OrderStatus orderStatus  = orderStatusService.findByCode(orderLine.getOrderStatus ().getCode());
				  if(orderStatus  == null)
				  orderLine.setOrderStatus (orderStatusService.save(orderLine.getOrderStatus ()));
				  else
				  orderLine.setOrderStatus (orderStatus );
			  }
	    
	          if(orderLine.getDeliveryMan()!=null){
                      User deliveryMan = userService.findById(orderLine.getDeliveryMan().getId());
				  
				  if(deliveryMan == null)
				  orderLine.setDeliveryMan(userService.save(orderLine.getDeliveryMan()));
				  else
				  orderLine.setDeliveryMan(deliveryMan);
			  }
	    
	          if(orderLine.getCollaborator()!=null){
                      User collaborator = userService.findById(orderLine.getCollaborator().getId());
				  
				  if(collaborator == null)
				  orderLine.setCollaborator(userService.save(orderLine.getCollaborator()));
				  else
				  orderLine.setCollaborator(collaborator);
			  }
	    
	          if(orderLine.getCommand()!=null){
				    Command command = commandService.findByReference(orderLine.getCommand().getReference());
				  if(command == null)
				  orderLine.setCommand(commandService.save(orderLine.getCommand()));
				  else
				  orderLine.setCommand(command);
			  }
	    
	          if(orderLine.getProduct()!=null){
				    Product product = productService.findById(orderLine.getProduct().getId());
				  if(product == null)
				  orderLine.setProduct(productService.save(orderLine.getProduct()));
				  else
				  orderLine.setProduct(product);
			  }

	    OrderLine savedOrderLine = orderLineDao.save(orderLine);
	   return savedOrderLine;
	}

    @Override
    public List<OrderLine> save(List<OrderLine> orderLines){
		List<OrderLine> list = new ArrayList<OrderLine>();
		for(OrderLine orderLine: orderLines){
		        list.add(save(orderLine));	
		}
		return list;
	}


   @Override
   public OrderLine update(OrderLine orderLine){
     
    
		  OrderLine foundedOrderLine = findById(orderLine.getId()); 
		       if(foundedOrderLine==null)
	          return null;	  
	  
	   return  orderLineDao.save(orderLine);
     
     }
    
	@Override
	@Transactional
	public int delete(OrderLine orderLine){

		 if(orderLine.getId()==null)
			  return -1;
		  OrderLine foundedOrderLine = findById(orderLine.getId()); 
		       if(foundedOrderLine==null)
	          return -1;	  
	   orderLineDao.delete(foundedOrderLine);
	   return 1;
	}


	public List<OrderLine> findByCriteria(OrderLineVo orderLineVo){
      String query = "SELECT o FROM OrderLine o where 1=1 ";
	  query += SearchUtil.addConstraintDate( "o", "dateAcceptationCollaborator","=",orderLineVo.getDateAcceptationCollaborator());
	  query += SearchUtil.addConstraintDate( "o", "datePreparationCollaborator","=",orderLineVo.getDatePreparationCollaborator());
	  query += SearchUtil.addConstraintDate( "o", "dateRecuperationDelivery","=",orderLineVo.getDateRecuperationDelivery());
			 query += SearchUtil.addConstraint( "o", "rejectionReason","LIKE",orderLineVo.getRejectionReason());

			 query += SearchUtil.addConstraint( "o", "description","LIKE",orderLineVo.getDescription());

	  query += SearchUtil.addConstraintDate( "o", "dateSubmissionToCollaborator","=",orderLineVo.getDateSubmissionToCollaborator());
		 	 query += SearchUtil.addConstraint( "o", "longitudeCollaborator","=",orderLineVo.getLongitudeCollaborator());
		 	 query += SearchUtil.addConstraint( "o", "latitudeCollaborator","=",orderLineVo.getLatitudeCollaborator());
	  query += SearchUtil.addConstraintDate( "o", "dateRejectionCllaborator","=",orderLineVo.getDateRejectionCllaborator());
	  query += SearchUtil.addConstraintDate( "o", "dateRejectionDelivery","=",orderLineVo.getDateRejectionDelivery());
	  query += SearchUtil.addConstraintDate( "o", "dateSubmissionDelivery","=",orderLineVo.getDateSubmissionDelivery());
	  query += SearchUtil.addConstraintDate( "o", "dateAcceptationDelivery","=",orderLineVo.getDateAcceptationDelivery());
			 query += SearchUtil.addConstraint( "o", "dateDelivery","LIKE",orderLineVo.getDateDelivery());

		 	 query += SearchUtil.addConstraint( "o", "preparedQte","=",orderLineVo.getPreparedQte());
		 	 query += SearchUtil.addConstraint( "o", "sentQte","=",orderLineVo.getSentQte());
		 	 query += SearchUtil.addConstraint( "o", "price","=",orderLineVo.getPrice());
		 	 query += SearchUtil.addConstraint( "o", "id","=",orderLineVo.getId());
		 	 query += SearchUtil.addConstraint( "o", "orderedQte","=",orderLineVo.getOrderedQte());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateAcceptationCollaborator",orderLineVo.getDateAcceptationCollaboratorMin(),orderLineVo.getDateAcceptationCollaboratorMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","datePreparationCollaborator",orderLineVo.getDatePreparationCollaboratorMin(),orderLineVo.getDatePreparationCollaboratorMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateRecuperationDelivery",orderLineVo.getDateRecuperationDeliveryMin(),orderLineVo.getDateRecuperationDeliveryMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateSubmissionToCollaborator",orderLineVo.getDateSubmissionToCollaboratorMin(),orderLineVo.getDateSubmissionToCollaboratorMax());
	  query += SearchUtil.addConstraintMinMax("o","longitudeCollaborator",orderLineVo.getLongitudeCollaboratorMin(),orderLineVo.getLongitudeCollaboratorMax());
	  query += SearchUtil.addConstraintMinMax("o","latitudeCollaborator",orderLineVo.getLatitudeCollaboratorMin(),orderLineVo.getLatitudeCollaboratorMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateRejectionCllaborator",orderLineVo.getDateRejectionCllaboratorMin(),orderLineVo.getDateRejectionCllaboratorMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateRejectionDelivery",orderLineVo.getDateRejectionDeliveryMin(),orderLineVo.getDateRejectionDeliveryMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateSubmissionDelivery",orderLineVo.getDateSubmissionDeliveryMin(),orderLineVo.getDateSubmissionDeliveryMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateAcceptationDelivery",orderLineVo.getDateAcceptationDeliveryMin(),orderLineVo.getDateAcceptationDeliveryMax());
	  query += SearchUtil.addConstraintMinMax("o","preparedQte",orderLineVo.getPreparedQteMin(),orderLineVo.getPreparedQteMax());
	  query += SearchUtil.addConstraintMinMax("o","sentQte",orderLineVo.getSentQteMin(),orderLineVo.getSentQteMax());
	  query += SearchUtil.addConstraintMinMax("o","price",orderLineVo.getPriceMin(),orderLineVo.getPriceMax());
	  query += SearchUtil.addConstraintMinMax("o","orderedQte",orderLineVo.getOrderedQteMin(),orderLineVo.getOrderedQteMax());
   if(orderLineVo.getOrderStatusVo()!=null){
     query += SearchUtil.addConstraint( "o", "orderStatus .id","=",orderLineVo.getOrderStatusVo().getId());
     query += SearchUtil.addConstraint( "o", "orderStatus .code","LIKE",orderLineVo.getOrderStatusVo().getCode());
   }
   
   if(orderLineVo.getDeliveryManVo()!=null){
     query += SearchUtil.addConstraint( "o", "deliveryMan.id","=",orderLineVo.getDeliveryManVo().getId());
   }
   
   if(orderLineVo.getCollaboratorVo()!=null){
     query += SearchUtil.addConstraint( "o", "collaborator.id","=",orderLineVo.getCollaboratorVo().getId());
   }
   
   if(orderLineVo.getCommandVo()!=null){
     query += SearchUtil.addConstraint( "o", "command.id","=",orderLineVo.getCommandVo().getId());
     query += SearchUtil.addConstraint( "o", "command.reference","LIKE",orderLineVo.getCommandVo().getReference());
   }
   
   if(orderLineVo.getProductVo()!=null){
     query += SearchUtil.addConstraint( "o", "product.id","=",orderLineVo.getProductVo().getId());
     query += SearchUtil.addConstraint( "o", "product.reference","LIKE",orderLineVo.getProductVo().getReference());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}

	@Override
	public OrderLine updateOrderStatus(OrderLine orderLine) {
		OrderLine dbOrderLine;
		if (orderLine!=null && orderLine.getId()!=null){
			dbOrderLine= findById(orderLine.getId());
			if (dbOrderLine!=null && orderLine.getOrderStatus()!=null){
				OrderStatus dbOrderStatus= orderStatusService.findById(orderLine.getOrderStatus().getId());
				if (dbOrderStatus!=null){
					dbOrderLine.setOrderStatus(dbOrderStatus);
					orderLineDao.save(orderLine);
					return dbOrderLine;
				}
			}

		}
		return null;
	}
}
