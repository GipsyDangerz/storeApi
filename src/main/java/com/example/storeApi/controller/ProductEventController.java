package com.example.storeApi.controller;

import com.example.storeApi.model.ProductEvent;
import com.example.storeApi.repository.ProductEventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class ProductEventController {

    private final ProductEventRepository repository;

    public ProductEventController(ProductEventRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProductEvent> getAllEvents() {
        return repository.findAll();
    }
}