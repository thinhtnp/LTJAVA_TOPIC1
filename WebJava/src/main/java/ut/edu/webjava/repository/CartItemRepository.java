package ut.edu.webjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
