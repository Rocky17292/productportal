package com.assignment.productportal.repository;

import com.assignment.productportal.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByVisibleToCustomerTrue();
}
