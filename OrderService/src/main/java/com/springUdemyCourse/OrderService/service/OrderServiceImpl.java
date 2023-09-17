package com.springUdemyCourse.OrderService.service;

import com.springUdemyCourse.OrderService.co.OrderCO;
import com.springUdemyCourse.OrderService.dto.OrderDTO;
import com.springUdemyCourse.OrderService.exception.CustomException;
import com.springUdemyCourse.OrderService.external.client.PaymentService;
import com.springUdemyCourse.OrderService.external.client.ProductService;
import com.springUdemyCourse.OrderService.external.co.PaymentCO;
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


    @Autowired
    PaymentService paymentService;

    @Override
    public Long placeOrder(OrderCO orderCO) {
        log.info("Placing order of {} by calling productService", orderCO);
        // Check Product Exist from Product MicroService and reduce quantity it exists
        productService.reduceQuantity(orderCO.getProductId(), orderCO.getQuantity());

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
        log.info("Making Payment {} By Calling PaymentService", orderCO);
        PaymentCO paymentCO = PaymentCO.builder()
                .paymentMode(orderCO.getPaymentMode())
                .orderId(order.getId())
                .amount(order.getAmount()).build();
        try {
            paymentService.doPayment(paymentCO);
            order.setOrderStatus(OrderStatus.CREATED);
            log.info("Order  placed successfully");
        } catch (Exception e) {
            log.info("Order cancelled because {}", e.getMessage());
            order.setOrderStatus(OrderStatus.CANCELLED);
        }
        orderRepository.saveAndFlush(order);

        return orderCreated.getId();
    }

    @Override
    public OrderDTO getOrderDetails(Long orderId) {
        Orders orders  = orderRepository.findById(orderId).orElseThrow(()->new CustomException("Invalid Requst","INVALID_ORDER_ID",403));
        if(orders!=null){
            return new OrderDTO().builder().orderId(orders.getId())
                    .amount(orders.getAmount())
                    .orderStatus(orders.getOrderStatus().name()).orderDate(orders.getOrderDate()).build();
        }else{
            throw new CustomException("Invalid Requst","INVALID_ORDER_ID",403);
        }
    }
}
