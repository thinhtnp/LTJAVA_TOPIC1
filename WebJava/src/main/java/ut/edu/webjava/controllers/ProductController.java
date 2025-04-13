package ut.edu.webjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ut.edu.webjava.models.Product;
import ut.edu.webjava.services.ProductService;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import ut.edu.webjava.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private ProductRepository productRepository;

    // Lấy danh sách tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Lấy sản phẩm theo Category ID
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    // Thêm hoặc cập nhật sản phẩm
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public String listProducts(Model model) {
//        model.addAttribute("productList", productRepository.findAll());
//        return "product_list"; // Trả về template product_list.html
//    }
}
