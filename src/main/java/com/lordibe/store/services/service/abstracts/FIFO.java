package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FIFO {
    @Getter
    static Deque<CustomerCart<CustomerServices, Map<String, Integer>, Integer>> queueCheckout = new ArrayDeque<>();

    public static void setQueueCheckout(CustomerCart<CustomerServices, Map<String, Integer>, Integer> cart) {
        FIFO.queueCheckout.offer(cart);
    }
}
