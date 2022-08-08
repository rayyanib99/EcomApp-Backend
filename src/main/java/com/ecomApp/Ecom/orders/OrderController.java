package com.ecomApp.Ecom.orders;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import com.ecomApp.Ecom.cart.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("*")
public class OrderController 
{
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders()
    {
        return orderService.listAllOrders();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Orders> getProductById(@PathVariable long id)
    {
        Orders order = orderService.getOrdersById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found: " +  id));
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public void insertOrder(@RequestBody Orders orders)
    {
        orderService.addOrder(orders);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> cancelOrder(@PathVariable long id)
    {
        Orders orders = orderService.getOrdersById(id).orElseThrow(() -> new ResourceNotFoundException("Cancel Order Error: " +  id));
        orderService.deleteOrder(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
