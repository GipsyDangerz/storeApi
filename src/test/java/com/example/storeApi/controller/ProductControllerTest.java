package com.example.storeApi.controller;

import com.example.storeApi.model.Product;
import com.example.storeApi.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    private ProductService productService;
    private ProductController productController;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        productController = new ProductController(productService);
    }

    @Test
    void shouldCreateProduct() {
        Product input = new Product(null, "Test", 12.5, "Category");
        Product saved = new Product(1L, "Test", 12.5, "Category");

        when(productService.create(any())).thenReturn(saved);

        Product result = productController.create(input);

        assertNotNull(result);
        assertEquals("Test", result.getName());
        verify(productService, times(1)).create(input);
    }

    @Test
    void shouldReturnAllProducts() {
        List<Product> mockList = List.of(
                new Product(1L, "P1", 1.0, "C1"),
                new Product(2L, "P2", 2.0, "C2")
        );

        when(productService.findAll()).thenReturn(mockList);

        List<Product> result = productController.getAll();

        assertEquals(2, result.size());
        verify(productService, times(1)).findAll();
    }
}
