package com.springUdemyCourse.ProductService.controller;

import com.springUdemyCourse.ProductService.co.ProductCO;
import com.springUdemyCourse.ProductService.dto.ProductDTO;
import com.springUdemyCourse.ProductService.models.Product;
import com.springUdemyCourse.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Long> addProduct(@RequestBody ProductCO productCO){
        long productId = productService.addProduct(productCO);
        return  new ResponseEntity<>(productId, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> addProduct(@PathVariable long id){
        ProductDTO productDTO = productService.getProduct(id);
        return  new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/reduceQuantity/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity){
        productService.reduceQunatity(productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
