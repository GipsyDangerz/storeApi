package com.example.storeApi.controller;

import com.example.storeApi.model.Product;
import com.example.storeApi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Product create(@Valid @RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PatchMapping("/{id}/price")
    @PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
    public Product updatePrice(@PathVariable Long id, @RequestParam Double price) {
        return productService.updatePrice(id, price);
    }
}
