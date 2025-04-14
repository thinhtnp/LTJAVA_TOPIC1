package ut.edu.webjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ut.edu.webjava.models.Cart;
import ut.edu.webjava.models.User;
import ut.edu.webjava.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/view")
    public String viewCartPage(@RequestParam Long userId, Model model) {
        User user = new User();
        user.setId(userId);
        Cart cart = cartService.getCartByUser(user);
        model.addAttribute("cart", cart);
        return "cart_view"; // Thymeleaf template
    }
}
