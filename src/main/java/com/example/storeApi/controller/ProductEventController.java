package com.example.storeApi.controller;

import com.example.storeApi.model.ProductEvent;
import com.example.storeApi.repository.ProductEventRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class ProductEventController {

    private final ProductEventRepository eventRepository;

    public ProductEventController(ProductEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<ProductEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}
