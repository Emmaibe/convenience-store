package com.lordibe.store.abstracts;

import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;
import com.lordibe.store.services.service.ManagerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @BeforeEach
    void setUp() {
        new ManagerServices().updateStock();
    }

    @Test
    void ReturnsCorrectMapIfNameIsFound() {
        String productName = "goldenmorn";

        Map<String, Products> expectedResult = Stock.getGroceries();

        Map<String, Products> result = Check.checkStock(productName);

        assertEquals(expectedResult, result);
    }

    @Test
    void checkStockProductDoesNotExistReturnsNull() {
        String productName = "NonExistentProduct";

        Map<String, Products> expectedResult = null;

        Map<String, Products> result = Check.checkStock(productName);

        assertNull(result);
    }
}