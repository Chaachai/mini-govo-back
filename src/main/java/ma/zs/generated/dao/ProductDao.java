package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Product;


@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

	Product findByReference(String reference);
       int deleteByReference(String reference);

       List<Product> findByCategoryProduitLabel(String label);
       int deleteByCategoryProduitLabel(String label);       
       List<Product> findByCategoryProduitId(Long id);
       int deleteByCategoryProduitId(Long id);
       List<Product> findByMesureUnitLabel(String label);
       int deleteByMesureUnitLabel(String label);       
       List<Product> findByMesureUnitId(Long id);
       int deleteByMesureUnitId(Long id);

}