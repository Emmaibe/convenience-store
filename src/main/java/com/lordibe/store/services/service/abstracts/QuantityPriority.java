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
    static Deque<CustomerCart<CustomerServices, Map<String, Integer>, Integer>> quantityQueueCheckout = new LinkedList<>();

    public static void setQuantityQueueCheckout(CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart) {
        FIFO.queueCheckout.offer(cart);
    }

    public static Deque<CustomerCart<CustomerServices, Map<String, Integer>, Integer>> getQuantityQueueCheckout() {
        return quantityQueueCheckout;
    }
}
