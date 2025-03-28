package ut.edu.webjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ut.edu.webjava.models.Cart;
import ut.edu.webjava.models.CartItem;
import ut.edu.webjava.models.Product;
import ut.edu.webjava.models.User;
import ut.edu.webjava.repositories.CartItemRepository;
import ut.edu.webjava.repositories.CartRepository;
import ut.edu.webjava.repositories.ProductRepository;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCartByUser(User user) {
        return cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart(user);
            return cartRepository.save(newCart);
        });
    }

    public Cart addToCart(User user, Long productId, int quantity) {
        Cart cart = getCartByUser(user);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (productOpt.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product product = productOpt.get();
        CartItem newItem = new CartItem(cart, product, quantity);
        cart.addItem(newItem);
        cartItemRepository.save(newItem);
        return cartRepository.save(cart);
    }

    public void removeItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(User user) {
        Cart cart = getCartByUser(user);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
