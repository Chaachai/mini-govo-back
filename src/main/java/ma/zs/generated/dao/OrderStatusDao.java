package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.OrderStatus;


@Repository
public interface OrderStatusDao extends JpaRepository<OrderStatus,Long> {

	OrderStatus findByCode(String code);
       int deleteByCode(String code);

       List<OrderStatus> findBySuperOrderStatusCode(String code);
       int deleteBySuperOrderStatusCode(String code);       
       List<OrderStatus> findBySuperOrderStatusId(Long id);
       int deleteBySuperOrderStatusId(Long id);

}