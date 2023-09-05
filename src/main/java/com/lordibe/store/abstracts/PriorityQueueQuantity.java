package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriorityQueueQuantity {
    @Getter
    static Queue<CustomerServices> quantityQueueCheckout = new PriorityQueue<>();

    public static void setQuantityQueueCheckout(CustomerServices customer) {
        PriorityQueueQuantity.quantityQueueCheckout.offer(customer);
    }

    public static void checkQueue() {
        for (CustomerServices cus : quantityQueueCheckout) {
            cus.getTotalQuantity();
        }
    }
}
