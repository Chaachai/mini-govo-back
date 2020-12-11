package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.SuperCategoryProduct;


@Repository
public interface SuperCategoryProductDao extends JpaRepository<SuperCategoryProduct,Long> {

	SuperCategoryProduct findByLabel(String label);
       int deleteByLabel(String label);


}