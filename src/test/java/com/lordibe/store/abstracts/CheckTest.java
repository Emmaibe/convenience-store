package com.lordibe.store.abstracts;

import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    @Test
    void checkStock_ProductExistsInAlcoholCategory_ReturnsCorrectMap() {
        // Arrange
        String productName = "goldenmorn";

        Map<String, Products> expectedResult = Stock.getGroceries();

        // Act
        Map<String, Products> result = Check.checkStock(productName);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    void checkStock_ProductDoesNotExist_ReturnsNull() {
        // Arrange
        String productName = "NonExistentProduct";
        Map<String, Products> expectedResult = null;
        // Act
        Map<String, Products> result = Check.checkStock(productName);
        // Assert
        assertNull(result);
    }
}