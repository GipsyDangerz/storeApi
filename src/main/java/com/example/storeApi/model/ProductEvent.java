package com.example.storeApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String eventType;
    private String category;
    private double price;
    private LocalDateTime eventTime;

    public ProductEvent(String productName, String category, double price, String eventType) {
        this.productName = productName;
        this.category = category;
        this.eventType = eventType;
        this.price = price;
        this.eventTime = LocalDateTime.now();
    }
}
