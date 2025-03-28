package ut.edu.webjava.controllers.Admin;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin() {
        return "admin/index"; // Spring Boot sẽ tìm file index.html trong /templates/
    }
}

=======
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class AdminController {
    @GetMapping("/admin")
    public String Admin() {
        return "admin/admin";
    }
}
>>>>>>> 950fac321e6fdb57da86a844c2305727e67c1ecc
