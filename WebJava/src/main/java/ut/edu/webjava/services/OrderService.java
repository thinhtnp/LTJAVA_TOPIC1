package ut.edu.webjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.edu.webjava.models.Order;
import ut.edu.webjava.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service // Đánh dấu lớp là một service trong Spring
public class OrderService {
    private final OrderRepository orderRepository;

    // Constructor injection cho OrderRepository
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Lấy danh sách tất cả các đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Tìm đơn hàng theo ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Lưu hoặc cập nhật một đơn hàng
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    // Xóa đơn hàng theo ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
