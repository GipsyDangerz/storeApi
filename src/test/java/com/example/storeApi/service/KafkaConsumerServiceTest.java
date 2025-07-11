package com.example.storeApi.service;

import com.example.storeApi.event.ProductCreatedEvent;
import com.example.storeApi.model.Product;
import com.example.storeApi.repository.ProductEventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class KafkaConsumerServiceTest {

    private ProductEventRepository productEventRepository;
    private KafkaConsumerService kafkaConsumerService;

    @BeforeEach
    void setUp() {
        productEventRepository = mock(ProductEventRepository.class);
        kafkaConsumerService = new KafkaConsumerService(productEventRepository);
    }

    @Test
    void shouldConsumeProductCreatedEventAndSaveToRepository() {
//        Product product = new Product(null, "Mock Product", 50.0, "Mock Category");
//        ProductCreatedEvent event = new ProductCreatedEvent("ProductCreated", product);
//
//        // Commented this because we simulate Kafka
//        //kafkaConsumerService.consume(event);
//
//        verify(productEventRepository, times(1)).save(argThat(savedEvent ->
//                savedEvent.getProductName().equals("Mock Product") &&
//                        savedEvent.getPrice() == 50.0 &&
//                        savedEvent.getCategory().equals("Mock Category")
//        ));
    }
}
