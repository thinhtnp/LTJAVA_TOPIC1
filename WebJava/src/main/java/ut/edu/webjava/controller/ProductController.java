//package ut.edu.webjava.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ut.edu.webjava.models.Product;
//import ut.edu.webjava.service.ProductService;
//import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
//import ut.edu.webjava.repository.ProductRepository;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//    @Autowired
//    private ProductService productService;
//    private ProductRepository productRepository;
//
//    // Lấy danh sách tất cả sản phẩm
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.findAll();
//    }
//
//    // Lấy sản phẩm theo ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//        Optional<Product> product = productService.findById(id);
//        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    // Lấy sản phẩm theo Category ID
//    @GetMapping("/category/{categoryId}")
//    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
//        return productService.findByCategoryId(categoryId);
//    }
//
//    // Thêm hoặc cập nhật sản phẩm
//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.save(product);
//    }
//
//    // Xóa sản phẩm
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
//        productService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//    @GetMapping("/product.html  ")
//    public String showProductList(Model model) {
//        model.addAttribute("products", productService.findAll());
//        return "product"; // Đảm bảo rằng trang này là product.html
//    }
//
////
////    @GetMapping("/list-products.html")
////    public String showProductList(Model model) {
////        model.addAttribute("products", productService.findAll());
////        model.addAttribute("product", new Product()); // for the form
////        return "list-product";
////    }
//}
