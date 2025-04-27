//package ut.edu.webjava.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ut.edu.webjava.models.Category;
//import ut.edu.webjava.service.CategoryService;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/categories")
//public class CategoryController {
//    @Autowired
//    private CategoryService categoryService;
//
//    // Lấy danh sách tất cả danh mục
//    @GetMapping
//    public List<Category> getAllCategories() {
//        return categoryService.findAll();
//    }
//
//    // Lấy danh mục theo ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
//        Optional<Category> category = categoryService.findById(id);
//        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Thêm hoặc cập nhật danh mục
//    @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.save(category);
//    }
//
//    // Xóa danh mục
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
//        categoryService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//}
