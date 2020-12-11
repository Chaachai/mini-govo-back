package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.MesureUnit;


@Repository
public interface MesureUnitDao extends JpaRepository<MesureUnit,Long> {

	MesureUnit findByLabel(String label);
       int deleteByLabel(String label);


}