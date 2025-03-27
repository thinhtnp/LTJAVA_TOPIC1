package ut.edu.webjava.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/admin")
    public String indexPage() {
        return "admin/index"; // Spring Boot sẽ tìm file index.html trong /templates/
    }
}

