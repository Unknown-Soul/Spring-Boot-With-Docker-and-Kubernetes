package com.springUdemyCourse.PaymentService.repository;

import com.springUdemyCourse.PaymentService.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository  extends JpaRepository<TransactionDetail,Long> {

}
