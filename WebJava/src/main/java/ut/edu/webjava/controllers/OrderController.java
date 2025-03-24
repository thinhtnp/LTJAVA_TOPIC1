package ut.edu.webjava.controllers; // Package chứa lớp controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ut.edu.webjava.models.Order;
import ut.edu.webjava.services.OrderService;

import java.util.List;
import java.util.Optional;

@RestController // Đánh dấu lớp là một REST controller
@RequestMapping("/api/orders") // Định nghĩa đường dẫn API chung cho controller
public class OrderController {

    private final OrderService orderService; // Service để xử lý logic liên quan đến Order

    @Autowired // Tiêm OrderService vào OrderController
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Lấy danh sách tất cả các đơn hàng
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders(); // Gọi service để lấy danh sách đơn hàng
    }

    // Lấy đơn hàng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id); // Gọi service để tìm đơn hàng theo ID
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Trả về 404 nếu không tìm thấy
    }

    // Tạo mới hoặc cập nhật đơn hàng
    @PostMapping
    public Order createOrUpdateOrder(@RequestBody Order order) {
        return orderService.saveOrder(order); // Gọi service để lưu hoặc cập nhật đơn hàng
    }

    // Xóa đơn hàng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id); // Gọi service để xóa đơn hàng theo ID
        return ResponseEntity.noContent().build(); // Trả về 204 nếu xóa thành công
    }
}
