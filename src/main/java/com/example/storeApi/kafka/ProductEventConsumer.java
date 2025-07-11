package com.example.storeApi.kafka;

import com.example.storeApi.event.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductEventConsumer {

    @KafkaListener(topics = "product-created", groupId = "analytics-group")
    public void consume(ProductCreatedEvent event) {
        log.info("Received ProductCreatedEvent: {}", event);
    }
}
