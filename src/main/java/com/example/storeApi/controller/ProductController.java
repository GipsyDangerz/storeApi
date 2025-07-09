package com.example.storeApi.controller;

import com.example.storeApi.model.Product;
import com.example.storeApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product create(@Valid @RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}/price")
    public Product updatePrice(@PathVariable Long id, @RequestParam Double price) {
        return service.updatePrice(id, price);
    }
}
