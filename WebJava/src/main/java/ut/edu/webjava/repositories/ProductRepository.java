package ut.edu.webjava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Tim tat ca san pham theo categoryId.
    List<Product> findByCategoryId(Long categoryId);
}
