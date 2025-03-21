package ut.edu.webjava.models; // Đảm bảo đúng package

import jakarta.persistence.*; // Import các annotation JPA
import java.math.BigDecimal; // Import kiểu BigDecimal

@Entity
@Table(name = "order_items") // Ánh xạ với bảng "order_items" trong DB
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị ID
    private Long id; // ID của OrderItem

    @ManyToOne // Mối quan hệ nhiều-1 với Order
    @JoinColumn(name = "order_id", nullable = false) // Khóa ngoại tham chiếu bảng "orders"
    private Order order; // Đơn hàng chứa sản phẩm này

    @ManyToOne // Mối quan hệ nhiều-1 với Product
    @JoinColumn(name = "product_id", nullable = false) // Khóa ngoại tham chiếu bảng "products"
    private Product product; // Sản phẩm cụ thể trong đơn hàng

    @Column(nullable = false) // Không được phép null
    private int quantity; // Số lượng sản phẩm

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; // Giá tiền của sản phẩm (tối đa 10 chữ số, 2 chữ số thập phân)

    // Constructor không tham số
    public OrderItem() {}

    // Constructor có tham số
    public OrderItem(Order order, Product product, int quantity, BigDecimal price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter và Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
