package ut.edu.webjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/feature")
    public String feature() {
        return "feature";
    }

    @GetMapping("/404")
    public String notFound() {
        return "404";
    }
}
