package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Rating;


@Repository
public interface RatingDao extends JpaRepository<Rating,Long> {


       List<Rating> findByClientId(Long id);
       int deleteByClientId(Long id);
       List<Rating> findByOrderLineId(Long id);
       int deleteByOrderLineId(Long id);
       List<Rating> findByCollaboratorId(Long id);
       int deleteByCollaboratorId(Long id);

}