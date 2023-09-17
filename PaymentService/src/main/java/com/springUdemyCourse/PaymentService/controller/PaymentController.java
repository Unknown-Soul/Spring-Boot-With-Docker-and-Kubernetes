package com.springUdemyCourse.PaymentService.controller;

import com.springUdemyCourse.PaymentService.co.PaymentCO;
import com.springUdemyCourse.PaymentService.service.PaymentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentCO paymentCO){
        return new ResponseEntity<>(
                paymentService.doPayment(paymentCO),
                HttpStatus.OK
        );
    }
}
