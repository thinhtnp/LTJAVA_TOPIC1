package ut.edu.webjava.controllers.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class AdminController {
    @GetMapping("/admin")
    public String Admin() {
        return "admin/admin";
    }
}
