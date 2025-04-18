package ut.edu.webjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ut.edu.webjava.dto.CreateUserRequest;
import ut.edu.webjava.models.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "/checklogin/login"; // trỏ đến file login.html trong templates
    }

    // Hiển thị trang đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new CreateUserRequest());
        return "checklogin/register";
    }
}
