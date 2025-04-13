package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.Cart;
import ut.edu.webjava.models.User;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}


