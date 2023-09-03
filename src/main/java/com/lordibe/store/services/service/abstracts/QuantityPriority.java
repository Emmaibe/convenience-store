package com.lordibe.store.services.service.abstracts;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuantityPriority {
    static Deque<Map<String, Integer>> quantityQueueCheckout = new LinkedList<>();

    public static void setQuantityQueueCheckout(Map<String, Integer> cart) {
        FIFO.queueCheckout.offer(cart);
    }

    public static Deque<Map<String, Integer>> getQuantityQueueCheckout() {
        return quantityQueueCheckout;
    }
}
