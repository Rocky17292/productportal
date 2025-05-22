package com.assignment.productportal.controller;

import com.assignment.productportal.model.Product;
import com.assignment.productportal.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/products")
public class CustomerProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getVisibleProducts() {
        return ResponseEntity.ok(productRepository.findByVisibleToCustomerTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVisibleProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .filter(Product::isVisibleToCustomer)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(403).body("Product not available"));
    }

}
