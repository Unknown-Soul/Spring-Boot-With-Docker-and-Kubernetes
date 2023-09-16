package com.springUdemyCourse.OrderService.co;

import com.springUdemyCourse.OrderService.helpers.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCO {
    private  long productId;
    private long totalAmount;
    private  long quantity;
    private PaymentMode paymentMode;
}
