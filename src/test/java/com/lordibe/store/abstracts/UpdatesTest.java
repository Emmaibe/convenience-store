package com.lordibe.store.abstracts;

import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.services.service.ManagerServices;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdatesTest {
    String productName = "Bread";
    int productPrice = 500;
    PRODUCT_CATEGORY PRODUCTCATEGORY = PRODUCT_CATEGORY.GROCERIES;
    int qntyOfProduct = 100;

    @BeforeEach
    void setUp() {
        new ManagerServices().updateStock();
        Updates.setPath("./src/main/resources/test.csv");
    }

    @AfterEach
    void reset() {
        Updates.setPath("./src/main/resources/Stock.csv");
    }

    @Test
    void updateStockFileSuccessful () {
        String outcome = Updates.updateStockFile(productName, productPrice, PRODUCTCATEGORY, qntyOfProduct);

        assertEquals("successful", outcome);
    }

    @Test
    void syncStockFileSuccessful () {
        String outcome = Updates.syncStock();

        assertEquals("successful", outcome);
    }
}