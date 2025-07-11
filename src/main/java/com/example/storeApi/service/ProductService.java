package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import com.example.storeApi.exception.ProductNotFoundException;
import com.example.storeApi.model.Product;
import com.example.storeApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final KafkaProducerService kafkaProducerService;

    public ProductService(ProductRepository productRepository, KafkaProducerService kafkaProducerService) {
        this.productRepository = productRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public Product create(Product product) {
        Product createdProduct = productRepository.save(product);

        ProductCreatedEvent event = new ProductCreatedEvent();
        event.setEventType("Product Created");
        event.setProduct(product);

        kafkaProducerService.publishProductCreated(event);
        return createdProduct;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public Product updatePrice(Long id, Double newPrice) {
        Product product = findById(id);
        product.setPrice(newPrice);
        return productRepository.save(product);
    }
}
