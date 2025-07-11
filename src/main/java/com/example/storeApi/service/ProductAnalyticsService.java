package com.example.storeApi.service;

import com.example.storeApi.model.ProductEvent;
import com.example.storeApi.repository.ProductEventRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductAnalyticsService {

    private final ProductEventRepository eventRepository;

    public ProductAnalyticsService(ProductEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void processEvent(ProductEvent event) {
        System.out.println("Processing event: " + event.getProductName());
        eventRepository.save(event);
    }
}
