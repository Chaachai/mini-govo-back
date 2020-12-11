package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.CategoryProduit;


@Repository
public interface CategoryProduitDao extends JpaRepository<CategoryProduit,Long> {

	CategoryProduit findByLabel(String label);
       int deleteByLabel(String label);

       List<CategoryProduit> findBySuperCategoryProductLabel(String label);
       int deleteBySuperCategoryProductLabel(String label);       
       List<CategoryProduit> findBySuperCategoryProductId(Long id);
       int deleteBySuperCategoryProductId(Long id);

}