package com.springUdemyCourse.ProductService.service;

import com.springUdemyCourse.ProductService.co.ProductCO;
import com.springUdemyCourse.ProductService.dto.ProductDTO;

public interface ProductService {
    long addProduct(ProductCO productCO);

    ProductDTO getProduct(long id);

    void reduceQunatity(long productId, long quantity);
}
