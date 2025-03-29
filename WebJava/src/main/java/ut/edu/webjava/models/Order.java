package ut.edu.webjava.models; // Đảm bảo đúng package của lớp, cần đặt trong thư mục phù hợp với cấu trúc project.

import jakarta.persistence.*; // Import các annotation JPA cần thiết như @Entity, @Table, @Id, @OneToMany,...
import java.math.BigDecimal; // Import kiểu dữ liệu BigDecimal để lưu trữ số thập phân (thường dùng cho tiền tệ).
import java.time.LocalDateTime; // Import kiểu dữ liệu LocalDateTime để lưu trữ thời gian ngày giờ.
import java.util.List; // Import kiểu danh sách (List) để lưu danh sách các đối tượng liên quan.
import ut.edu.webjava.models.OrderItem; // Import lớp OrderItem để sử dụng trong định nghĩa quan hệ.
import ut.edu.webjava.models.User; // Import lớp User để thiết lập quan hệ với đơn hàng.

@Entity // Đánh dấu đây là một thực thể JPA (được ánh xạ với bảng trong cơ sở dữ liệu).
@Table(name = "orders") // Xác định bảng ánh xạ là "orders".
public class Order { // Khai báo lớp Order.

    @Id // Đánh dấu thuộc tính id là khóa chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị id theo cơ chế của cơ sở dữ liệu.
    private Long id; // Thuộc tính id (khóa chính) của bảng orders.

    @Enumerated(EnumType.STRING) // Dùng Enum thay vì String để tránh lỗi dữ liệu.
    private OrderStatus status; // Trạng thái của đơn hàng.

    @Column(nullable = false) // Cột orderDate không được phép null.
    private LocalDateTime orderDate; // Thuộc tính lưu trữ thời gian đặt hàng.

    // Created_date
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate; // Ngày tạo đơn hàng, không được cập nhật lại.

    @Column(nullable = false, precision = 10, scale = 2) // Định nghĩa cột totalAmount với độ chính xác 10 chữ số, 2 chữ số thập phân, không được null.
    private BigDecimal totalAmount; // Thuộc tính lưu tổng số tiền của đơn hàng.

    @ManyToOne // Mối quan hệ nhiều-1: Một đơn hàng thuộc về một người dùng.
    @JoinColumn(name = "user_id", nullable = false) // Khóa ngoại liên kết với bảng users.
    private User user; // Người dùng đặt hàng.

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    // Định nghĩa mối quan hệ 1-n giữa Order và OrderItem.
    // - `mappedBy = "order"`: Liên kết với thuộc tính `order` trong lớp OrderItem.
    // - `cascade = CascadeType.ALL`: Thực hiện các thao tác (INSERT, UPDATE, DELETE) liên quan đến orderItem khi thao tác với order.
    // - `orphanRemoval = true`: Xóa các orderItem không còn liên kết với order.
    private List<OrderItem> orderItems; // Danh sách các OrderItem liên kết với đơn hàng.

    // Enum đại diện cho trạng thái đơn hàng
    public enum OrderStatus {
        PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELED
    }

    // Constructors
    public Order() {} // Constructor không tham số (dùng cho JPA).

    public Order(LocalDateTime orderDate, BigDecimal totalAmount, User user, List<OrderItem> orderItems) {
        // Constructor có tham số để khởi tạo Order với dữ liệu cụ thể.
        this.orderDate = orderDate; // Gán giá trị thời gian đặt hàng.
        this.totalAmount = totalAmount; // Gán giá trị tổng số tiền.
        this.user = user; // Gán người dùng đặt hàng.
        this.orderItems = orderItems; // Gán danh sách các orderItem.
        this.status = OrderStatus.PENDING; // Mặc định trạng thái ban đầu là "PENDING".
    }

    // Getters & Setters
    public Long getId() { return id; } // Trả về id của đơn hàng.
    public void setId(Long id) { this.id = id; } // Gán giá trị id cho đơn hàng.

    public OrderStatus getStatus() { return status; } // Trả về trạng thái đơn hàng.
    public void setStatus(OrderStatus status) { this.status = status; } // Gán trạng thái đơn hàng.

    public LocalDateTime getOrderDate() { return orderDate; } // Trả về thời gian đặt hàng.
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; } // Gán thời gian đặt hàng.

    public LocalDateTime getCreatedDate() { return createdDate; } // Trả về ngày tạo đơn hàng.
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; } // Gán ngày tạo đơn hàng.

    public BigDecimal getTotalAmount() { return totalAmount; } // Trả về tổng số tiền của đơn hàng.
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; } // Gán tổng số tiền cho đơn hàng.

    public User getUser() { return user; } // Trả về người đặt hàng.
    public void setUser(User user) { this.user = user; } // Gán người đặt hàng.

    public List<OrderItem> getOrderItems() { return orderItems; } // Trả về danh sách OrderItem liên kết.
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; } // Gán danh sách OrderItem cho đơn hàng.

    // Tự động thiết lập giá trị createdDate khi tạo mới đơn hàng
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
}
