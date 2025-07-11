package com.example.storeApi.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ProductCreatedEvent implements Serializable {
    private Long id;
    private String name;
    private Double price;
    private String category;
}
