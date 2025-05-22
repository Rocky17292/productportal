package com.assignment.productportal.controller;

import com.assignment.productportal.model.Product;
import com.assignment.productportal.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/products")
public class AdminProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optional.get();
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setVisibleToCustomer(updatedProduct.isVisibleToCustomer());

        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if (!productRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        productRepository.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/toggle")
    public ResponseEntity<?> toggleVisibility(@PathVariable Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = optional.get();
        product.setVisibleToCustomer(!product.isVisibleToCustomer());
        productRepository.save(product);

        return ResponseEntity.ok("Visibility changed to: " + product.isVisibleToCustomer());
    }
}
