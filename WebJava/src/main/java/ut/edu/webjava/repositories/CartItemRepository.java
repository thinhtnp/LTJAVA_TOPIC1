package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
