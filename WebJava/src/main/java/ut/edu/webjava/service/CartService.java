package ut.edu.webjava.service;

import java.util.List;

import ut.edu.webjava.models.Cart;

public interface CartService {

    public Cart saveCart(Integer productId, Integer userId);

    public List<Cart> getCartsByUser(Integer userId);

    public Integer getCountCart(Integer userId);

    public void updateQuantity(String sy, Integer cid);

}