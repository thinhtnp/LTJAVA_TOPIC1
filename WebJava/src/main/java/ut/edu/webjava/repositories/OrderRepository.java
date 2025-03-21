package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.Order;

// Repository cho entity Order, cung cấp các thao tác CRUD
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Các phương thức mặc định từ JpaRepository:
    // - findAll()
    // - findById(Long id)
    // - save(Order order)
    // - deleteById(Long id)
    // Có thể bổ sung các truy vấn tùy chỉnh nếu cần
}
