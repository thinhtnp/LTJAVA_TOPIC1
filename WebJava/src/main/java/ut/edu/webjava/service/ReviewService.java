package ut.edu.webjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.edu.webjava.models.ProductOrder;
import ut.edu.webjava.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository; // Sử dụng final để đảm bảo bất biến

    // ✅ Constructor Injection
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<ProductOrder> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<ProductOrder> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public ProductOrder saveReview(ProductOrder review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}

