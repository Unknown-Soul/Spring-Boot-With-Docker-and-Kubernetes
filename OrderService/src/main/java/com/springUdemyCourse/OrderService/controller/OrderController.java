package com.springUdemyCourse.OrderService.controller;

import com.springUdemyCourse.OrderService.co.OrderCO;
import com.springUdemyCourse.OrderService.dto.OrderDTO;
import com.springUdemyCourse.OrderService.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/paceOrder", method = RequestMethod.POST)
    public ResponseEntity<Long> placeOrder(@RequestBody OrderCO orderCO){
        Long orderID = orderService.placeOrder(orderCO);
        log.info("Order id {} created", orderID);
        return ResponseEntity.ok(orderID);
    }



    @RequestMapping(value = "/getOrder/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long  orderId){
        log.info("Getting Order Details for id {}", orderId);
        OrderDTO orderDTO = orderService.getOrderDetails(orderId);
        return ResponseEntity.ok(orderDTO);
    }


}
