package com.EcommerceMarketplace.Controller;

import com.EcommerceMarketplace.Entity.OrderEntity;
import com.EcommerceMarketplace.Entity.OrderItems;
import com.EcommerceMarketplace.Entity.OrderItemsEntity;
import com.EcommerceMarketplace.Service.OrderService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping("/getOrderById")
    public ResponseEntity<OrderEntity> getOrder(@RequestParam Integer id){
        return orderService.getOrder(id);
    }

    @GetMapping("/getOrderByUserId")
    public ResponseEntity<OrderEntity> getOrderByUserId(@RequestParam Integer uid){
        return orderService.getOrderByUser(uid);
    }

    @PostMapping("/placeOrder")

    public ResponseEntity<String> placeOrder(@RequestBody List<OrderItems> orderItems){
        return orderService.placeOrder(orderItems);
    }

}
