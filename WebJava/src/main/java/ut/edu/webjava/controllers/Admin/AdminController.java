package ut.edu.webjava.controllers.Admin;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ut.edu.webjava.controllers.ProductController;
import ut.edu.webjava.models.Product;
import ut.edu.webjava.services.ProductService;


import java.util.List;
import java.util.Scanner;


@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin"; // Spring Boot sẽ tìm file index.html trong /templates/
        
        
    }




    }

