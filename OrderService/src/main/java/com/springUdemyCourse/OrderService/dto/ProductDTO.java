package com.springUdemyCourse.OrderService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private long id;
    private String name;
    private long price;
//    private long quantity;
}
