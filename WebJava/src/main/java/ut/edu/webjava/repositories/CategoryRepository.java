package ut.edu.webjava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import ut.edu.webjava.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

