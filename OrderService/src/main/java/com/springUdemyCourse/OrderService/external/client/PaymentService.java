package com.springUdemyCourse.OrderService.external.client;

import com.springUdemyCourse.OrderService.external.co.PaymentCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="PAYMENT-SERVICE/payment")
public interface PaymentService {
    @PostMapping("/")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentCO paymentCO);
}
