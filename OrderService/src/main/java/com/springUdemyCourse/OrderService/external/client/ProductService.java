package com.springUdemyCourse.OrderService.external.client;

import com.springUdemyCourse.OrderService.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE/product")
public interface ProductService {
    @RequestMapping(value = "/reduceQuantity/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity);

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable long id);
}
