package com.springUdemyCourse.PaymentService.service;

import com.springUdemyCourse.PaymentService.co.PaymentCO;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Long doPayment(PaymentCO paymentCO);
}
