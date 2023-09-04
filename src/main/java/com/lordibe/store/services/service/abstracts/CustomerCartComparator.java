package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;

import java.util.Comparator;
import java.util.Map;

public class CustomerCartComparator implements Comparator<CustomerCart<CustomerServices, Map<String, Integer>, Integer>> {

    public int compare(CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart1, CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart2) {
        // Compare based on totalQuantity field
        return cart1.getPRODUCT_QUANTITY().compareTo(cart2.getPRODUCT_QUANTITY());
    }
}
