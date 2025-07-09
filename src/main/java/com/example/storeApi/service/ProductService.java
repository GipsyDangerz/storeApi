package com.example.storeApi.service;

import com.example.storeApi.model.Product;
import com.example.storeApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updatePrice(Long id, Double newPrice) {
        Product product = findById(id);
        product.setPrice(newPrice);
        return repository.save(product);
    }
}
