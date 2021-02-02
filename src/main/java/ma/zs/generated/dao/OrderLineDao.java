package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.OrderLine;


@Repository
public interface OrderLineDao extends JpaRepository<OrderLine,Long> {


       List<OrderLine> findByOrderStatusCode(String code);
       int deleteByOrderStatusCode(String code);
       List<OrderLine> findByOrderStatusId(Long id);
       int deleteByOrderStatusId(Long id);
       List<OrderLine> findByDeliveryManId(Long id);
       int deleteByDeliveryManId(Long id);
       List<OrderLine> findByCollaboratorId(Long id);
       int deleteByCollaboratorId(Long id);
       List<OrderLine> findByCommandReference(String reference);
       int deleteByCommandReference(String reference);       
       List<OrderLine> findByCommandId(Long id);
       int deleteByCommandId(Long id);
       List<OrderLine> findByProductReference(String reference);
       int deleteByProductReference(String reference);       
       List<OrderLine> findByProductId(Long id);
       int deleteByProductId(Long id);
       
     //list des taches affectées a un collab
       List<OrderLine> findByCollaboratorIdAndDateAcceptationCollaboratorIsNull(Long id);
       
       //list des taches d'un collab
       List<OrderLine> findByCollaboratorIdAndDateAcceptationCollaboratorIsNotNull(Long id);
       
       //collab ignore tache
       @Modifying
       @Query("update OrderLine o set o.collaborator.id = null where o.id = :id")
       int ignorerTache(Long id);
       
       //change task status
       @Modifying
       @Query("update OrderLine o set o.orderStatus.id = :statusId where o.id = :id")
       int changeStatus(Long id , Long statusId);
       
       
     //collab ignore tache
       @Modifying
       @Query("update OrderLine o set o.dateAcceptationCollaborator = current_time() where o.id = :id")
       int enchargerTache(Long id);

}