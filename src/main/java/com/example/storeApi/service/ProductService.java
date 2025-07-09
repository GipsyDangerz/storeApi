package com.example.storeApi.service;

import com.example.storeApi.model.Product;
import com.example.storeApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updatePrice(Long id, Double newPrice) {
        Product product = findById(id);
        product.setPrice(newPrice);
        return productRepository.save(product);
    }
}
