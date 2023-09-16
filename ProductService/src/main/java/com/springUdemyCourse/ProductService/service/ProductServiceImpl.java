package com.springUdemyCourse.ProductService.service;

import com.springUdemyCourse.ProductService.co.ProductCO;
import com.springUdemyCourse.ProductService.dto.ProductDTO;
import com.springUdemyCourse.ProductService.exception.ProductServiceCustomException;
import com.springUdemyCourse.ProductService.models.Product;
import com.springUdemyCourse.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductCO productCO) {
        log.info("Adding Product...");
        Product product = Product
                .builder()
                .productName(productCO.getName())
                .quantity(productCO.getQuantity())
                .price(productCO.getPrice())
                .build();
        productRepository.save(product);
        log.info("product created");
        return product.getProductId();
    }

    @Override
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ProductServiceCustomException("Product Id not found", "PRODUCT_NOT_FOUND"));
        if(!Objects.isNull(product)){
            return ProductDTO.builder()
                    .id(product.getProductId())
                    .price(product.getPrice())
                    .quantity(product.getQuantity())
                    .name(product.getProductName()).build();
        }
        return new ProductDTO();
    }

    @Override
    public void reduceQunatity(long productId, long quantity) {
        log.info("Reduce Quantity for ProductId {} and Quantity {}", productId, quantity);
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"
                ));
        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomException("Product doest not have sufficent Quntaitu","INSUFFICIANT QUNATITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product Quntity updated");
    }
}
