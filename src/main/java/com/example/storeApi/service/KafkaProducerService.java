package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import com.example.storeApi.model.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

    private final ProductAnalyticsService analyticsService;

    public KafkaProducerService(ProductAnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    public void publishProductCreated(ProductCreatedEvent event) {
        System.out.println("Simulating publish to Kafka: " + event);

        ProductEvent productEvent = new ProductEvent(
                event.getProduct().getName(),
                event.getProduct().getCategory(),
                event.getProduct().getPrice(),
                event.getEventType()
        );
        analyticsService.processEvent(productEvent);
    }
}
