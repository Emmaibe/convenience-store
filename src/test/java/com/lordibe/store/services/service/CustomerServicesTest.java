package com.lordibe.store.services.service;

import com.lordibe.store.abstracts.Check;
import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.model.product.Products;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesTest {

//    Map<String, Integer> cart = customerTest.getCartContent();

    @Test
    void addToCart() {
        CustomerServices customerTest = new CustomerServices("Obinna", "08035462791");
        Map<String, Integer> cart = customerTest.getCartContent();
        customerTest.addToCart("bread", 6);
        customerTest.addToCart("tea", 2);
        customerTest.addToCart("gin", 3);

        // Assuming addToCart returns a specific message

        assertTrue(cart.keySet().contains("tea"));
    }
}