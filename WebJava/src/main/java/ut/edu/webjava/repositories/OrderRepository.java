package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ut.edu.webjava.models.Order;

import java.time.LocalDateTime;
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


    // Tìm danh sách đơn hàng theo trạng thái
    //List<Order> findByStatus(String status);

    // Tìm danh sách đơn hàng theo mã khách hàng
    //List<Order> findByCustomerId(Long customerId);

    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Tìm danh sách đơn hàng theo khoảng ngày tạo
    List<Order> findByCreatedDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Tìm danh sách đơn hàng với tổng tiền lớn hơn một giá trị cụ thể
    //List<Order> findByTotalAmountGreaterThan(Double amount);

}

