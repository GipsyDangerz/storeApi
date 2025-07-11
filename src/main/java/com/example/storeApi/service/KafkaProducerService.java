package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;

    private static final String TOPIC = "product-created";

    public void publishProductCreated(ProductCreatedEvent event) {
        log.info("Sending ProductCreatedEvent to Kafka: {}", event);
        kafkaTemplate.send(TOPIC, event);
    }
}
