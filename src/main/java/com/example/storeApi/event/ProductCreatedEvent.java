package com.example.storeApi.event;

import com.example.storeApi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent implements Serializable {
    private String eventType;
    private Product product;
}
