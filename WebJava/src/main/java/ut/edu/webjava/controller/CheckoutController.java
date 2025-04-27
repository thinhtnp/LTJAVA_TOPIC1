//package ut.edu.webjava.controller;
//import ut.edu.webjava.models.Cart;
//import ut.edu.webjava.models.UserDtls;
//import ut.edu.webjava.service.CartService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//@Controller
//public class CheckoutController {
//
//    @Autowired
//    private CartService cartService;
//
//    @GetMapping("/checkout")
//    public String showCheckoutForm(@RequestParam Long userId, Model model) {
//        UserDtls user = new UserDtls();
//        user.setId(userId);
//        Cart cart = cartService.getCartByUser(user);
//        model.addAttribute("cart", cart);
//        model.addAttribute("userId", userId);
//        return "checkout";
//    }
//
//    @PostMapping("/checkout/confirm")
//    public String confirmCheckout(@RequestParam String name,
//                                  @RequestParam String address,
//                                  @RequestParam String phone,
//                                  @RequestParam Long userId,
//                                  Model model) {
//        System.out.println("Name: " + name + ", Address: " + address + ", Phone: " + phone + ", UserId: " + userId);
//        model.addAttribute("message", "Đặt hàng thành công!");
//        return "redirect:/products";
//    }
//}
