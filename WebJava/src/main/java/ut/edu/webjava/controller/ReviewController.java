//package ut.edu.webjava.controller; // Package chứa lớp controller
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ut.edu.webjava.models.ProductOrder;
//import ut.edu.webjava.service.ReviewService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController // Đánh dấu lớp là một REST controller
//@RequestMapping("/api/reviews") // Định nghĩa đường dẫn API chung cho controller
//public class ReviewController {
//
//    private final ReviewService reviewService; // Service để xử lý logic liên quan đến Review
//
//    @Autowired // Tiêm ReviewService vào ReviewController
//    public ReviewController(ReviewService reviewService) {
//        this.reviewService = reviewService;
//    }
//
//    // Lấy danh sách tất cả các đánh giá
//    @GetMapping
//    public List<ProductOrder> getAllReviews() {
//        return reviewService.getAllReviews(); // Gọi service để lấy danh sách đánh giá
//    }
//
//    // Lấy đánh giá theo ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductOrder> getReviewById(@PathVariable Long id) {
//        Optional<ProductOrder> review = reviewService.getReviewById(id); // Gọi service để tìm đánh giá theo ID
//        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Trả về 404 nếu không tìm thấy
//    }
//
//    // Tạo mới đánh giá
//    @PostMapping
//    public ResponseEntity<ProductOrder> createReview(@RequestBody ProductOrder review) {
//        return ResponseEntity.ok(reviewService.saveReview(review)); // Gọi service để lưu đánh giá
//    }
//
//    // Cập nhật đánh giá theo ID
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductOrder> updateReview(@PathVariable Long id, @RequestBody ProductOrder reviewDetails) {
//        Optional<ProductOrder> optionalReview = reviewService.getReviewById(id);
//
//        if (optionalReview.isPresent()) {
//            ProductOrder review = optionalReview.get();
//            review.setAuthor(reviewDetails.getAuthor());
//            review.setContent(reviewDetails.getContent());
//            review.setRating(reviewDetails.getRating());
//
//            return ResponseEntity.ok(reviewService.saveReview(review));
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Xóa đánh giá theo ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        reviewService.deleteReview(id); // Gọi service để xóa đánh giá theo ID
//        return ResponseEntity.noContent().build(); // Trả về 204 nếu xóa thành công
//    }
//}
