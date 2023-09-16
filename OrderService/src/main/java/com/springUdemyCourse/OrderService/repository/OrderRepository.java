package com.springUdemyCourse.OrderService.repository;

import com.springUdemyCourse.OrderService.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
