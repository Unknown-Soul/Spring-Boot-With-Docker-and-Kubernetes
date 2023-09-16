package com.springUdemyCourse.ProductService.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long productId;
        @Column(name="product_name")
        private String productName;
        private long price;
        private long quantity;

}
