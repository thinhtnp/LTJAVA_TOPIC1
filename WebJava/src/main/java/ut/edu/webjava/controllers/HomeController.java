package ut.edu.webjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String Home() {
        return "admin/index"; // Tên file trong thư mục templates
    }
}

