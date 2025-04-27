//package ut.edu.webjava.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ut.edu.webjava.repository.ProductRepository;
//
//@Controller
//@RequestMapping("/products")
//public class ProductWebController {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @GetMapping
//    public String listProducts(Model model) {
//        model.addAttribute("productList", productRepository.findAll());
//        return "admin/list-products"; // Tên file HTML trong thư mục templates
//    }
//}
