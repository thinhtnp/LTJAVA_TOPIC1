package ut.edu.webjava.models; // Đảm bảo đúng package của lớp, cần đặt trong thư mục phù hợp với cấu trúc project.

import jakarta.persistence.*; // Import các annotation JPA cần thiết như @Entity, @Table, @Id, @OneToMany,...
import java.math.BigDecimal; // Import kiểu dữ liệu BigDecimal để lưu trữ số thập phân (thường dùng cho tiền tệ).
import java.time.LocalDateTime; // Import kiểu dữ liệu LocalDateTime để lưu trữ thời gian ngày giờ.
import java.util.List; // Import kiểu danh sách (List) để lưu danh sách các đối tượng liên quan.
import ut.edu.webjava.models.OrderItem; // Import lớp OrderItem để sử dụng trong định nghĩa quan hệ.

@Entity // Đánh dấu đây là một thực thể JPA (được ánh xạ với bảng trong cơ sở dữ liệu).
@Table(name = "orders") // Xác định bảng ánh xạ là "orders".
public class Order { // Khai báo lớp Order.

    @Id // Đánh dấu thuộc tính id là khóa chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị id theo cơ chế của cơ sở dữ liệu.
    private Long id; // Thuộc tính id (khóa chính) của bảng orders.
    private String status;
    @Column(nullable = false) // Cột orderDate không được phép null.
    private LocalDateTime orderDate; // Thuộc tính lưu trữ thời gian đặt hàng.

    // Created_date
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @Column(nullable = false, precision = 10, scale = 2) // Định nghĩa cột totalAmount với độ chính xác 10 chữ số, 2 chữ số thập phân, không được null.
    private BigDecimal totalAmount; // Thuộc tính lưu tổng số tiền của đơn hàng.

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    // Định nghĩa mối quan hệ 1-n giữa Order và OrderItem.
    // - `mappedBy = "order"`: Liên kết với thuộc tính `order` trong lớp OrderItem.
    // - `cascade = CascadeType.ALL`: Thực hiện các thao tác (INSERT, UPDATE, DELETE) liên quan đến orderItem khi thao tác với order.
    // - `orphanRemoval = true`: Xóa các orderItem không còn liên kết với order.
    private List<OrderItem> orderItems; // Danh sách các OrderItem liên kết với đơn hàng.

    // Constructors
    public Order() {} // Constructor không tham số (dùng cho JPA).

    public Order(LocalDateTime orderDate, BigDecimal totalAmount, List<OrderItem> orderItems) {
        // Constructor có tham số để khởi tạo Order với dữ liệu cụ thể.
        this.orderDate = orderDate; // Gán giá trị thời gian đặt hàng.
        this.totalAmount = totalAmount; // Gán giá trị tổng số tiền.
        this.orderItems = orderItems; // Gán danh sách các orderItem.
    }

    // Getters & Setters
    public Long getId() { return id; } // Trả về id của đơn hàng.
    public void setId(Long id) { this.id = id; } // Gán giá trị id cho đơn hàng.
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() { return orderDate; } // Trả về thời gian đặt hàng.
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; } // Gán thời gian đặt hàng.

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    // Tự động thiết lập giá trị createdDate khi tạo mới đơn hàng
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }
    public BigDecimal getTotalAmount() { return totalAmount; } // Trả về tổng số tiền của đơn hàng.
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; } // Gán tổng số tiền cho đơn hàng.

    public List<OrderItem> getOrderItems() { return orderItems; } // Trả về danh sách OrderItem liên kết.
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; } // Gán danh sách OrderItem cho đơn hàng.
}
