package com.ecomApp.Ecom.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService 
{
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> listAllOrders()
    {
        return orderRepository.findAll();
    }

    public void addOrder(Orders orders) 
    {
        orderRepository.save(orders);
    }

    public Optional<Orders> getOrdersById(Long id) 
    {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id)
    {
        orderRepository.deleteById(id);
    }

    public Orders updateOrders(Long id, Orders orders) 
    {
        Orders orders1 = orderRepository.findById(id).get();

        orders1.setName(orders.getName());
        orders1.setProductCategory(orders.getProductCategory());
        orders1.setUnitPrice(orders.getUnitPrice());
        orders1.setProductImage(orders.getProductImage());
        orders1.setOrderPrice(orders.getOrderPrice());
        orders1.setOrderDate(orders.getOrderDate());
        orders1.setQuantity(orders.getQuantity());
        orders1.setOrderDate(orders.getOrderDate());
        
        orderRepository.save(orders1);
        return orders;
    }
}
