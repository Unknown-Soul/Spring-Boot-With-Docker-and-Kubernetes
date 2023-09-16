package com.springUdemyCourse.OrderService.service;

import com.springUdemyCourse.OrderService.co.OrderCO;

public interface OrderService {
    Long placeOrder(OrderCO orderCO);
}
