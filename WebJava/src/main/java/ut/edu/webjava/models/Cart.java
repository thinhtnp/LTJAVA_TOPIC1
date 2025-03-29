package ut.edu.webjava.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects; // Thêm để hỗ trợ equals() và hashCode()
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // Đảm bảo user không null
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) //Thêm fetch = FetchType.LAZY để tối ưu
    private Set<CartItem> items = new HashSet<>();

    public Cart() {}

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) { // Thêm setter cho user
        this.user = user;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        items.add(item);
        item.setCart(this);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
        item.setCart(null);
    }

    public void clearCart() { // Thêm phương thức xóa toàn bộ giỏ hàng
        for (CartItem item : items) {
            item.setCart(null);
        }
        items.clear();
    }

    @Override
    public boolean equals(Object o) { //  Cập nhật equals()
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) && Objects.equals(user, cart.user);
    }

    @Override
    public int hashCode() { // Cập nhật hashCode()
        return Objects.hash(id, user);
    }
}
