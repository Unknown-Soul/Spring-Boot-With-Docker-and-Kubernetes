package com.springUdemyCourse.OrderService.external.client;

import com.springUdemyCourse.OrderService.exception.CustomException;
import com.springUdemyCourse.OrderService.external.co.PaymentCO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name="external", fallbackMethod="fallback")
@FeignClient(name="PAYMENT-SERVICE/payment")
public interface PaymentService {
    @PostMapping("/")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentCO paymentCO);

    default  void fallback(Exception e){
        throw new CustomException("Payment Service is not unavilble", "UNAVAILABLE", 500);
    }
}
