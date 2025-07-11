package com.example.storeApi.repository;

import com.example.storeApi.model.ProductEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductEventRepository extends JpaRepository<ProductEvent, Long> {
}
