package com.ecomApp.Ecom.cart;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController 
{
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getAllCartItems()
    {
        return cartService.listAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cart> getProductById(@PathVariable long id)
    {
        Cart cartProduct = cartService.getProductsById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found: " +  id));
        return ResponseEntity.ok(cartProduct);
    }

    @PostMapping
    public void addToCart(@RequestBody Cart cart)
    {
        cartService.addCartProduct(cart);
    }

    @DeleteMapping("{id}")
    public void deleteCartProduct(@PathVariable Long id) 
    {
        cartService.deleteProductInCart(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) 
    {
        cart = cartService.updateCart(id, cart);
        return ResponseEntity.ok(cart);
    }
}
