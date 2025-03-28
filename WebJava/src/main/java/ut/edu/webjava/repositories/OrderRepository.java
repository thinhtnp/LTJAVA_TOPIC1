package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ut.edu.webjava.models.Order;

import java.util.List;

// Repository cho entity Order, cung cấp các thao tác CRUD
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Các phương thức mặc định từ JpaRepository:
    // - findAll(): Lấy tất cả các bản ghi
    // - findById(Long id): Tìm bản ghi theo ID
    // - save(Order order): Lưu hoặc cập nhật bản ghi
    // - deleteById(Long id): Xóa bản ghi theo ID

    // Các phương thức tùy chỉnh (truy vấn tự động dựa trên quy tắc đặt tên):

}


