package com.lordibe.store.services.service.abstracts;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.PriorityQueue;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FIFO {
    @Getter
    static PriorityQueue<Map<String, Integer>> queueCheckout = new PriorityQueue<>();

    public static void setQueueCheckout(Map<String, Integer> cart) {
        FIFO.queueCheckout.add(cart);
    }
}
