package ut.edu.webjava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}