package com.ecomApp.Ecom.orders;

import com.ecomApp.Ecom.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class OrderController 
{
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> getAllOrders()
    {
        return orderService.listAllOrders();
    }

    @PostMapping("/orders")
    public void insertOrder(@RequestBody Orders orders)
    {
        orderService.addOrder(orders);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<HttpStatus> cancelOrder(@PathVariable long id)
    {
        Orders orders = orderService.getOrdersById(id).orElseThrow(() -> new ResourceNotFoundException("Cancel Order Error: " +  id));
        orderService.deleteOrder(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
