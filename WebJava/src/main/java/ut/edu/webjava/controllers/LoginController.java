package ut.edu.webjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/checklogin/login"; // trỏ đến file login.html trong templates
    }
}
