package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import com.example.storeApi.model.ProductEvent;
import com.example.storeApi.repository.ProductEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
public class KafkaProducerService {

    private final ProductAnalyticsService analyticsService;

    public KafkaProducerService(ProductAnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    public void publishProductCreated(ProductCreatedEvent event) {
        System.out.println("📤 Simulating publish to Kafka: " + event);

        // Simulate consuming the event right away
        ProductEvent productEvent = new ProductEvent(
                event.getProduct().getName(),
                event.getProduct().getCategory(),
                event.getProduct().getPrice()
        );
        analyticsService.processEvent(productEvent);
    }
}
