package com.springUdemyCourse.OrderService.service;

import com.springUdemyCourse.OrderService.co.OrderCO;
import com.springUdemyCourse.OrderService.external.client.ProductService;
import com.springUdemyCourse.OrderService.helpers.OrderStatus;
import com.springUdemyCourse.OrderService.model.Orders;
import com.springUdemyCourse.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    @Override
    public Long placeOrder(OrderCO orderCO) {
        log.info("Placing order of {}", orderCO);
        // Check Product Exist from Product MicroService and reduce quantity it exists
        productService.reduceQuantity(orderCO.getProductId(),orderCO.getQuantity());

        // Order Object Creation
        Orders order = Orders.builder()
                .orderStatus(OrderStatus.CREATED)
                .quantity(orderCO.getQuantity())
                .amount(orderCO.getTotalAmount())
                .productId(orderCO.getProductId())
                .orderDate(Instant.now())
                .build();

        // making changes in OrderObject
        Orders orderCreated = orderRepository.saveAndFlush(order);
        log.info("Order {} place successfully", orderCO);

        // Payment Service : if success->complete else cancel
        return orderCreated.getId();
    }
}
