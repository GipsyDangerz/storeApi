package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import com.example.storeApi.model.ProductEvent;
import com.example.storeApi.repository.ProductEventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final ProductEventRepository productEventRepository;

    public KafkaConsumerService(ProductEventRepository productEventRepository) {
        this.productEventRepository = productEventRepository;
    }

    @KafkaListener(topics = "product-created", groupId = "store-group")
    public void consume(ProductCreatedEvent event) {
        ProductEvent entity = new ProductEvent(event.getName(), event.getCategory(), event.getPrice());
        productEventRepository.save(entity);
        System.out.println("Consumed and saved event: " + event.getName());
    }
}
