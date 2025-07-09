package com.example.storeApi.repository;

import com.example.storeApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Later: Add findByName, etc.
}