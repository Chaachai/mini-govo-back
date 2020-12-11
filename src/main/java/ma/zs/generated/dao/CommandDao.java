package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Command;


@Repository
public interface CommandDao extends JpaRepository<Command,Long> {

	Command findByReference(String reference);
       int deleteByReference(String reference);

       List<Command> findByAdminId(Long id);
       int deleteByAdminId(Long id);
       List<Command> findByDeliveryManId(Long id);
       int deleteByDeliveryManId(Long id);
       List<Command> findByClientId(Long id);
       int deleteByClientId(Long id);
       List<Command> findByCityName(String name);
       int deleteByCityName(String name);       
       List<Command> findByCityId(Long id);
       int deleteByCityId(Long id);
       List<Command> findByOrderStatusCode(String code);
       int deleteByOrderStatusCode(String code);       
       List<Command> findByOrderStatusId(Long id);
       int deleteByOrderStatusId(Long id);

}