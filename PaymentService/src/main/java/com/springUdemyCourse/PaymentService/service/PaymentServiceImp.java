package com.springUdemyCourse.PaymentService.service;

import com.springUdemyCourse.PaymentService.co.PaymentCO;
import com.springUdemyCourse.PaymentService.model.TransactionDetail;
import com.springUdemyCourse.PaymentService.repository.TransactionDetailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImp implements PaymentService {

    @Autowired
    TransactionDetailRepository transactionDetailRepository;


    @Override
    public Long doPayment(PaymentCO paymentCO) {
        log.info("Payment Details for {}", paymentCO);
        TransactionDetail transactionDetail = TransactionDetail.builder()
                .amount(paymentCO.getAmount())
                .orderId(paymentCO.getOrderId())
                .referenceNumber(paymentCO.getReferenceNumber())
                .paymentDate(Instant.now())
                .paymentMode(paymentCO.getPaymentMode())
                .build();
        transactionDetailRepository.save(transactionDetail);
        return transactionDetail.getId();
    }
}
