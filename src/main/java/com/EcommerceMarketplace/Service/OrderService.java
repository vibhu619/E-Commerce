package com.EcommerceMarketplace.Service;

import com.EcommerceMarketplace.Entity.OrderEntity;
import com.EcommerceMarketplace.Entity.OrderItems;
import com.EcommerceMarketplace.Entity.OrderItemsEntity;
import com.EcommerceMarketplace.Entity.ProductEntity;
import com.EcommerceMarketplace.Repository.OrderRepository;
import com.EcommerceMarketplace.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public ProductRepository productRepository;


    public ResponseEntity<OrderEntity> getOrder(Integer id) {
        OrderEntity order=orderRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    public ResponseEntity<OrderEntity> getOrderByUser(Integer uid) {
        OrderEntity order=orderRepository.findByUserId(uid).orElseThrow();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    public ResponseEntity<String>  placeOrder(List<OrderItems> orderItems) {
        OrderEntity orders=OrderEntity.builder().
                id(orderItems.stream()
                        .map(OrderItems::getOrderId)
                        .findAny()
                        .orElseThrow()).
                orderDate(LocalDate.now())
                .amount(getAmount(orderItems))
                .userId(1)
                .build();

        orderRepository.save(orders);

        return new ResponseEntity<>("Order placed",HttpStatus.OK);
    }

    private Integer getAmount(List<OrderItems> orderItems) {
        return orderItems.stream()
                .map(this::findAmountForOneProduct)
                .mapToInt(Integer::intValue)
                .sum();
    }



    private Integer findAmountForOneProduct(OrderItems orderItem){

       ProductEntity product=productRepository.findById(orderItem.getProductId()).orElseThrow();
        reduceQuantityOfProduct(product,orderItem);
       return product.getPrice()*orderItem.getQuantity();
    }

    private void reduceQuantityOfProduct(ProductEntity product, OrderItems orderItem) {
        product.setQuantity(product.getQuantity()-orderItem.getQuantity());
        productRepository.save(product);

    }
}
