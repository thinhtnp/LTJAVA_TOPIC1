package ut.edu.webjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ut.edu.webjava.models.ProductOrder;

@Repository
public interface ReviewRepository extends JpaRepository<ProductOrder, Long> {
}
