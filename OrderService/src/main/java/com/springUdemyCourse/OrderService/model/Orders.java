package com.springUdemyCourse.OrderService.model;

import com.springUdemyCourse.OrderService.helpers.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long productId;
    private long quantity;
    private Instant orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private long amount;
}
