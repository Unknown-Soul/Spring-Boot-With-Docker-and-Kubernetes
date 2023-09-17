package com.springUdemyCourse.PaymentService.dto;

import com.springUdemyCourse.PaymentService.helper.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}
