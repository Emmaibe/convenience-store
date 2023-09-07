package com.lordibe.store.services.service;

import com.lordibe.store.abstracts.Check;
import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.model.customer.Customer;
import com.lordibe.store.model.product.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesTest {
    CustomerServices customerTest = new CustomerServices("Obinna", "08035462791");
    ManagerServices ms = new ManagerServices();

    @BeforeEach
    void setUp() {
        ms.updateStock();

        customerTest.addToCart("bread", 6);
        customerTest.addToCart("tea", 2);
        customerTest.addToCart("gin", 3);
    }

    @Test
    void addToCartTest() {
        String outcome = customerTest.addToCart("vodka", 4);

        assertEquals("added", outcome);
        assertTrue(customerTest.getCartContent().containsKey("tea"));
    }

    @Test
    void mergedProductQuantityTest() {
        String outcome = customerTest.addToCart("bread", 4);

        assertEquals("merged", outcome);
        assertEquals(10, customerTest.getCartContent().get("bread"));
    }

    @Test
    void notInStock() {
        String outcome = customerTest.addToCart("notInCart", 4);

        assertEquals("failed", outcome);
    }

    @Test
    void conformTotalQuantity() {
        int totalQuantity = customerTest.getTotalQuantity();

        assertEquals(11, totalQuantity);
    }
}