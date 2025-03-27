package ut.edu.webjava.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin() {
        return "admin/index"; // Spring Boot sẽ tìm file index.html trong /templates/
    }
}

