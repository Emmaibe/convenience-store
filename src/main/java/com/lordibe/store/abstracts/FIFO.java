package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FIFO {
    @Getter
    static Deque<CustomerServices> queueCheckout = new ArrayDeque<>();

    public static void setQueueCheckout(CustomerServices customer) {
        FIFO.queueCheckout.offer(customer);
    }
}
