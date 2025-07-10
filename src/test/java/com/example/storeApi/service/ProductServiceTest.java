package com.example.storeApi.service;

import com.example.storeApi.model.Product;
import com.example.storeApi.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    void shouldCreateProduct() {
        Product input = new Product(null, "Test Product", 99.99, "TestCategory");
        Product saved = new Product(1L, "Test Product", 99.99, "TestCategory");

        when(productRepository.save(any())).thenReturn(saved);

        Product result = productService.create(input);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Test Product", result.getName());
    }

    @Test
    void shouldReturnAllProducts() {
        List<Product> mockList = List.of(
                new Product(1L, "A", 10.0, "X"),
                new Product(2L, "B", 20.0, "Y")
        );

        when(productRepository.findAll()).thenReturn(mockList);

        List<Product> result = productService.findAll();

        assertEquals(2, result.size());
        verify(productRepository, times(1)).findAll();
    }
}
