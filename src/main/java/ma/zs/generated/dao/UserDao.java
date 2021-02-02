package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.User;


@Repository
public interface UserDao extends JpaRepository<User,Long> {


    User findByEmail(String email);
 //   @Query("SELECT s.collaborator FROM SpecialiteCollaborator s WHERE s.collaborator.authority.authority='COLLABORATOR' AND s.categoryProduit.id=:id")
 @Query("SELECT u FROM SpecialiteCollaborator s JOIN s.collaborator u JOIN u.ratings r " +
         "WHERE u.authority.authority='COLLABORATOR'" +
         " AND s.categoryProduit.id=:id" +
         " group by u.id order by avg(r.mark) DESC ")
    List<User> findByCategoryProduitId(@Param("id") Long id);
}