package ut.edu.webjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ut.edu.webjava.models.Cart;
import ut.edu.webjava.models.User;
import ut.edu.webjava.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartApiController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<Cart> getCart(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        Cart cart = cartService.getCartByUser(user);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam int quantity) {
        User user = new User();
        user.setId(userId);
        Cart updatedCart = cartService.addToCart(user, productId, quantity);
        return ResponseEntity.ok(updatedCart);
    }
    @GetMapping("/count")
    public ResponseEntity<Integer> getCartItemCount(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        int count = cartService.getCartByUser(user).getItems().stream()
                .mapToInt(i -> i.getQuantity()).sum();
        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeItem(@PathVariable Long cartItemId) {
        cartService.removeItem(cartItemId);
        return ResponseEntity.ok("Item removed from cart");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(@RequestParam Long userId) {
        User user = new User();
        user.setId(userId);
        cartService.clearCart(user);
        return ResponseEntity.ok("Cart cleared");
    }
}
