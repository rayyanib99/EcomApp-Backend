package com.ecomApp.Ecom.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService 
{
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> listAllProducts()
    {
        return cartRepository.findAll();
    }

    public void addCartProduct(Cart cart) 
    {
        cartRepository.save(cart);
    }

    public Optional<Cart> getProductsById(Long cartId) 
    {
        return cartRepository.findById(cartId);
    }

    public void deleteProductInCart(Long id)
    {
        cartRepository.deleteById(id);
    }

    public List<Cart> getProductsByName(String productName)
    {
        return cartRepository.findByNameEqualsAllIgnoreCase(productName);
    }

    public Cart updateCart(Long id, Cart cart) 
    {
        Cart cart1 = cartRepository.findById(id).get();

        cart1.setName(cart.getName());
        cart1.setProductCategory(cart.getProductCategory());
        cart1.setUnitPrice(cart.getUnitPrice());
        cart1.setProductImage(cart.getProductImage());
        cart1.setQuantity(cart.getQuantity());

        cartRepository.save(cart1);
        return cart;
    }
}