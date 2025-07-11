package com.example.storeApi.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreatedEvent {
    private Long id;
    private String name;
    private Double price;
    private String category;
}
