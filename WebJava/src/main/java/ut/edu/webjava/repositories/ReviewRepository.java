package ut.edu.webjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ut.edu.webjava.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
