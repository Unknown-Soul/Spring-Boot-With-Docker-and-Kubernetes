package com.springUdemyCourse.OrderService.service;

import com.springUdemyCourse.OrderService.co.OrderCO;
import com.springUdemyCourse.OrderService.dto.OrderDTO;

public interface OrderService {
    Long placeOrder(OrderCO orderCO);

    OrderDTO getOrderDetails(Long orderId);
}
