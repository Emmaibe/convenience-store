package com.lordibe.store.model.product;

import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
        Stock stock;

        @BeforeEach
        void setUp() {
            stock = new Stock();
        }

        @Test
        void testAddToStock() {
            Map<String, Products> totalStock = Stock.getTotalStock();
            Map<String, Products> groceries = Stock.getGroceries();
            Map<String, Products> snacks = Stock.getSnacks();
            Map<String, Products> personalCare = Stock.getPersonalCare();
            Map<String, Products> health = Stock.getHealth();
            Map<String, Products> alcohol = Stock.getAlcohol();
            Map<String, Products> houseHoldItems = Stock.getHouseHoldItems();

            totalStock.put("bread", new Products("bread", 500, PRODUCT_CATEGORY.GROCERIES, 50));
            groceries.put("eggs", new Products("eggs", 500, PRODUCT_CATEGORY.GROCERIES, 50));
            totalStock.put("panadol", new Products("panadol", 500, PRODUCT_CATEGORY.HEALTH, 50));
            health.put("vitamin", new Products("vitamin", 500, PRODUCT_CATEGORY.HEALTH, 50));
            totalStock.put("brush", new Products("brush", 500, PRODUCT_CATEGORY.PERSONAL_CARE, 50));
            personalCare.put("paste", new Products("paste", 500, PRODUCT_CATEGORY.PERSONAL_CARE, 50));
            totalStock.put("torch", new Products("torch", 500, PRODUCT_CATEGORY.HOUSEHOLD_ITEMS, 50));
            houseHoldItems.put("battery", new Products("battery", 500, PRODUCT_CATEGORY.HOUSEHOLD_ITEMS, 50));
            totalStock.put("chips", new Products("chips", 500, PRODUCT_CATEGORY.SNACKS, 50));
            snacks.put("chocolate", new Products("chocolate", 500, PRODUCT_CATEGORY.SNACKS, 50));
            totalStock.put("vodka", new Products("vodka", 500, PRODUCT_CATEGORY.ALCOHOL, 50));
            alcohol.put("gin", new Products("gin", 500, PRODUCT_CATEGORY.ALCOHOL, 50));

            // Assertions for Groceries
            assertTrue(totalStock.containsKey("bread"));
            assertEquals(PRODUCT_CATEGORY.GROCERIES, totalStock.get("bread").getProductCategory());

            assertTrue(groceries.containsKey("eggs"));
            assertEquals(PRODUCT_CATEGORY.GROCERIES, groceries.get("eggs").getProductCategory());

            // Assertions for Snacks
            assertTrue(totalStock.containsKey("chips"));
            assertEquals(PRODUCT_CATEGORY.SNACKS, totalStock.get("chips").getProductCategory());

            assertTrue(snacks.containsKey("chocolate"));
            assertEquals(PRODUCT_CATEGORY.SNACKS, snacks.get("chocolate").getProductCategory());

            // Assertions for Personal Care
            assertTrue(totalStock.containsKey("brush"));
            assertEquals(PRODUCT_CATEGORY.PERSONAL_CARE, totalStock.get("brush").getProductCategory());

            assertTrue(personalCare.containsKey("paste"));
            assertEquals(PRODUCT_CATEGORY.PERSONAL_CARE, personalCare.get("paste").getProductCategory());

            // Assertions for Health
            assertTrue(totalStock.containsKey("panadol"));
            assertEquals(PRODUCT_CATEGORY.HEALTH, totalStock.get("panadol").getProductCategory());

            assertTrue(health.containsKey("vitamin"));
            assertEquals(PRODUCT_CATEGORY.HEALTH, health.get("vitamin").getProductCategory());

            // Assertions for Alcohol
            assertTrue(totalStock.containsKey("vodka"));
            assertEquals(PRODUCT_CATEGORY.ALCOHOL, totalStock.get("vodka").getProductCategory());

            assertTrue(alcohol.containsKey("gin"));
            assertEquals(PRODUCT_CATEGORY.ALCOHOL, alcohol.get("gin").getProductCategory());

            // Assertions for Household Items
            assertTrue(totalStock.containsKey("torch"));
            assertEquals(PRODUCT_CATEGORY.HOUSEHOLD_ITEMS, totalStock.get("torch").getProductCategory());

            assertTrue(houseHoldItems.containsKey("battery"));
            assertEquals(PRODUCT_CATEGORY.HOUSEHOLD_ITEMS, houseHoldItems.get("battery").getProductCategory());
        }
}