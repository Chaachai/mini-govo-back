package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.Comment;
import ma.zs.generated.dao.CommandDao;
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.service.facade.CommentService;   
import ma.zs.generated.service.facade.UserService;   
import ma.zs.generated.service.facade.OrderLineService;   
import ma.zs.generated.service.facade.CityService;   
import ma.zs.generated.service.facade.OrderStatusService;   

import ma.zs.generated.ws.rest.provided.vo.CommandVo;
import ma.zs.generated.service.util.*;
@Service
public class CommandServiceImpl implements CommandService {

   @Autowired
   private CommandDao commandDao;
   
    @Autowired
    private CommentService commentService ;
    @Autowired
    private UserService userService ;
    @Autowired
    private OrderLineService orderLineService ;
    @Autowired
    private CityService cityService ;
    @Autowired
    private OrderStatusService orderStatusService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Command> findAll(){
		return commandDao.findAll();
	}	
     @Override
    public List<Command> findByAdminId(Long id){
		return commandDao.findByAdminId(id);

	}
	   @Override
	   @Transactional
    public int deleteByAdminId(Long id){
		return commandDao.deleteByAdminId(id);

	}
     		
     @Override
    public List<Command> findByDeliveryManId(Long id){
		return commandDao.findByDeliveryManId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDeliveryManId(Long id){
		return commandDao.deleteByDeliveryManId(id);

	}
     		
     @Override
    public List<Command> findByClientId(Long id){
		return commandDao.findByClientId(id);

	}
	   @Override
	   @Transactional
    public int deleteByClientId(Long id){
		return commandDao.deleteByClientId(id);

	}
     		
	@Override
	public List<Command> findByCityName(String name){
		return commandDao.findByCityName(name);
	}
	@Override
	@Transactional
    public int deleteByCityName(String name){
		return commandDao.deleteByCityName(name);
	}
	
     @Override
    public List<Command> findByCityId(Long id){
		return commandDao.findByCityId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCityId(Long id){
		return commandDao.deleteByCityId(id);

	}
     		
	@Override
	public List<Command> findByOrderStatusCode(String code){
		return commandDao.findByOrderStatusCode(code);
	}
	@Override
	@Transactional
    public int deleteByOrderStatusCode(String code){
		return commandDao.deleteByOrderStatusCode(code);
	}
	
     @Override
    public List<Command> findByOrderStatusId(Long id){
		return commandDao.findByOrderStatusId(id);

	}
	   @Override
	   @Transactional
    public int deleteByOrderStatusId(Long id){
		return commandDao.deleteByOrderStatusId(id);

	}
     		
	@Override
	public Command findByReference(String reference){
		if( reference==null)
		  return null;
		return commandDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return commandDao.deleteByReference(reference);	 
	}

	@Override
	public Command findById(Long id){
		 if(id==null)
		  return null;
		return commandDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           commandDao.deleteById(id);
   }
	@Override	
	public Command save (Command command){
			Command foundedCommand = findByReference(command.getReference());
	       if(foundedCommand!=null)
	          return null;  
	    
	          if(command.getAdmin()!=null){
                      User admin = userService.findById(command.getAdmin().getId());
				  
				  if(admin == null)
				  command.setAdmin(userService.save(command.getAdmin()));
				  else
				  command.setAdmin(admin);
			  }
	    
	          if(command.getDeliveryMan()!=null){
                      User deliveryMan = userService.findById(command.getDeliveryMan().getId());
				  
				  if(deliveryMan == null)
				  command.setDeliveryMan(userService.save(command.getDeliveryMan()));
				  else
				  command.setDeliveryMan(deliveryMan);
			  }
	    
	          if(command.getClient()!=null){
                      User client = userService.findById(command.getClient().getId());
				  
				  if(client == null)
				  command.setClient(userService.save(command.getClient()));
				  else
				  command.setClient(client);
			  }
	    
	          if(command.getCity()!=null){
				    City city = cityService.findByName(command.getCity().getName());
				  if(city == null)
				  command.setCity(cityService.save(command.getCity()));
				  else
				  command.setCity(city);
			  }
	    
	          if(command.getOrderStatus()!=null){
				    OrderStatus orderStatus = orderStatusService.findByCode(command.getOrderStatus().getCode());
				  if(orderStatus == null)
				  command.setOrderStatus(orderStatusService.save(command.getOrderStatus()));
				  else
				  command.setOrderStatus(orderStatus);
			  }

	    Command savedCommand = commandDao.save(command);
               if(ListUtil.isNotEmpty(command.getOrderLines())){
		  savedCommand.setOrderLines(orderLineService.save(prepareOrderLines(savedCommand,command.getOrderLines())));
		 }
               if(ListUtil.isNotEmpty(command.getComments())){
		  savedCommand.setComments(commentService.save(prepareComments(savedCommand,command.getComments())));
		 }
	   return savedCommand;
	}

    @Override
    public List<Command> save(List<Command> commands){
		List<Command> list = new ArrayList<Command>();
		for(Command command: commands){
		        list.add(save(command));	
		}
		return list;
	}

     private List<OrderLine> prepareOrderLines(Command command,List<OrderLine> orderLines){
		    for(OrderLine orderLine:orderLines ){
                  orderLine.setCommand(command); 
			}
			return orderLines;
	  }
     private List<Comment> prepareComments(Command command,List<Comment> comments){
		    for(Comment comment:comments ){
                  comment.setCommand(command); 
			}
			return comments;
	  }

   @Override
   public Command update(Command command){
     
    
		  Command foundedCommand = findById(command.getId()); 
		       if(foundedCommand==null)
	          return null;	  
	  
	   return  commandDao.save(command);
     
     }
    
	@Override
	@Transactional
	public int delete(Command command){

	        if(command.getReference()==null)
			  return -1;
		
			Command foundedCommand = findByReference(command.getReference());
	       if(foundedCommand==null)
	          return -1;  
	   commandDao.delete(foundedCommand);
	   return 1;
	}


	public List<Command> findByCriteria(CommandVo commandVo){
      String query = "SELECT o FROM Command o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "commentResolution","=",commandVo.getCommentResolution());
	  query += SearchUtil.addConstraintDate( "o", "regulationDate","=",commandVo.getRegulationDate());
		 	 query += SearchUtil.addConstraint( "o", "longitudeDelivery","=",commandVo.getLongitudeDelivery());
	  query += SearchUtil.addConstraintDate( "o", "commentResolutionDate ","=",commandVo.getCommentResolutionDate ());
	  query += SearchUtil.addConstraintDate( "o", "dateSubmission","=",commandVo.getDateSubmission());
		 	 query += SearchUtil.addConstraint( "o", "nbrTotalComment","=",commandVo.getNbrTotalComment());
		 	 query += SearchUtil.addConstraint( "o", "yearCommand","=",commandVo.getYearCommand());
		 	 query += SearchUtil.addConstraint( "o", "latitudeDelivery","=",commandVo.getLatitudeDelivery());
	  query += SearchUtil.addConstraintDate( "o", "orderDate","=",commandVo.getOrderDate());
			 query += SearchUtil.addConstraint( "o", "address","LIKE",commandVo.getAddress());

			 query += SearchUtil.addConstraint( "o", "reference","LIKE",commandVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "id","=",commandVo.getId());
		 	 query += SearchUtil.addConstraint( "o", "dayCommand","=",commandVo.getDayCommand());
		 	 query += SearchUtil.addConstraint( "o", "monthCommand","=",commandVo.getMonthCommand());
			 query += SearchUtil.addConstraint( "o", "remark","LIKE",commandVo.getRemark());

		 	 query += SearchUtil.addConstraint( "o", "total","=",commandVo.getTotal());
	  query += SearchUtil.addConstraintMinMaxDate("o","regulationDate",commandVo.getRegulationDateMin(),commandVo.getRegulationDateMax());
	  query += SearchUtil.addConstraintMinMax("o","longitudeDelivery",commandVo.getLongitudeDeliveryMin(),commandVo.getLongitudeDeliveryMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","commentResolutionDate ",commandVo.getCommentResolutionDateMin(),commandVo.getCommentResolutionDateMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","dateSubmission",commandVo.getDateSubmissionMin(),commandVo.getDateSubmissionMax());
	  query += SearchUtil.addConstraintMinMax("o","nbrTotalComment",commandVo.getNbrTotalCommentMin(),commandVo.getNbrTotalCommentMax());
	  query += SearchUtil.addConstraintMinMax("o","yearCommand",commandVo.getYearCommandMin(),commandVo.getYearCommandMax());
	  query += SearchUtil.addConstraintMinMax("o","latitudeDelivery",commandVo.getLatitudeDeliveryMin(),commandVo.getLatitudeDeliveryMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","orderDate",commandVo.getOrderDateMin(),commandVo.getOrderDateMax());
	  query += SearchUtil.addConstraintMinMax("o","dayCommand",commandVo.getDayCommandMin(),commandVo.getDayCommandMax());
	  query += SearchUtil.addConstraintMinMax("o","monthCommand",commandVo.getMonthCommandMin(),commandVo.getMonthCommandMax());
	  query += SearchUtil.addConstraintMinMax("o","total",commandVo.getTotalMin(),commandVo.getTotalMax());
   if(commandVo.getAdminVo()!=null){
     query += SearchUtil.addConstraint( "o", "admin.id","=",commandVo.getAdminVo().getId());
   }
   
   if(commandVo.getDeliveryManVo()!=null){
     query += SearchUtil.addConstraint( "o", "deliveryMan.id","=",commandVo.getDeliveryManVo().getId());
   }
   
   if(commandVo.getClientVo()!=null){
     query += SearchUtil.addConstraint( "o", "client.id","=",commandVo.getClientVo().getId());
   }
   
   if(commandVo.getCityVo()!=null){
     query += SearchUtil.addConstraint( "o", "city.id","=",commandVo.getCityVo().getId());
     query += SearchUtil.addConstraint( "o", "city.name","LIKE",commandVo.getCityVo().getName());
   }
   
   if(commandVo.getOrderStatusVo()!=null){
     query += SearchUtil.addConstraint( "o", "orderStatus.id","=",commandVo.getOrderStatusVo().getId());
     query += SearchUtil.addConstraint( "o", "orderStatus.code","LIKE",commandVo.getOrderStatusVo().getCode());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
