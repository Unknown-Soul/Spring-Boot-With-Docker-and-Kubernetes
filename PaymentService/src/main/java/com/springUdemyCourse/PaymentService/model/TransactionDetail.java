package com.springUdemyCourse.PaymentService.model;

import com.springUdemyCourse.PaymentService.helper.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private Long orderId;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private String referenceNumber;
    private Instant paymentDate;
    private String paymentStatus;
    private Long amount;
}
