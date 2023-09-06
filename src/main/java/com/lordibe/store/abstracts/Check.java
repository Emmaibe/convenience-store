package com.lordibe.store.abstracts;

import com.lordibe.store.model.product.Products;
import com.lordibe.store.model.product.Stock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check {
    public static Map<String, Products> checkStock(String prodName) {
        List<Map<String, Products>> stockCategoryList = Arrays.asList(Stock.getAlcohol(), Stock.getHealth(), Stock.getGroceries(), Stock.getSnacks(), Stock.getHouseHoldItems(), Stock.getPersonalCare());

//        Map<String, Products> targetStock = null;

        for (Map<String, Products> productMap : stockCategoryList) {
            if (productMap.containsKey(prodName)) {
                Map<String, Products> targetStock = new HashMap<>(productMap);
                return targetStock;
            }
        }
        return null;
    }
}
