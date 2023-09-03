package com.lordibe.store.services.service.abstracts;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FIFO {
    @Getter
    static Queue<Map<String, Integer>> queueCheckout = new PriorityQueue<>();

    public static void setQueueCheckout(Map<String, Integer> cart) {
        FIFO.queueCheckout.offer(cart);
    }
}
