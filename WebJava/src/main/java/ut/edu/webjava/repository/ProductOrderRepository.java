package ut.edu.webjava.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ut.edu.webjava.models.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByUserId(Integer userId);

    ProductOrder findByOrderId(String orderId);

}
