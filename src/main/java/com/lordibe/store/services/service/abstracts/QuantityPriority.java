package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuantityPriority {
    @Getter
    static PriorityQueue<CustomerCart<CustomerServices, Map<String, Integer>, Integer>> quantityQueueCheckout = new PriorityQueue<>(Comparator.comparing(CustomerCart::getPRODUCT_QUANTITY));

    public static void setQuantityQueueCheckout(CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart) {
        QuantityPriority.quantityQueueCheckout.offer(cart);
    }

    public static void viewQuantityQueueCheckOut() {
        for (CustomerCart<CustomerServices, Map<String, Integer>, Integer> n : QuantityPriority.quantityQueueCheckout) {
            System.out.println(n.getPRODUCT_QUANTITY());
        }
    }


}
