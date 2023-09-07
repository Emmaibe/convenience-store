package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.service.ManagerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueQuantityTest {
    CustomerServices customer1 = new CustomerServices("bisola", "08084323456");
    CustomerServices customer2 = new CustomerServices("dolapo", "08084758476");
    CustomerServices customer3 = new CustomerServices("mudia", "08080987496");

    @BeforeEach
    void setUP() {
        new ManagerServices().updateStock();
    }

    @Test
    void firstNumberOutTest() {
        //customer1
        customer1.addToCart("tea", 6);
        customer1.addToCart("bread", 1);
        //customer2
        customer2.addToCart("goldenmorn", 2);
        customer2.addToCart("chips", 9);
        //customer3
        customer3.addToCart("bread", 30);

        //sending to priorityQueue
        customer2.checkOutQuantityPriority();
        customer1.checkOutQuantityPriority();
        customer3.checkOutQuantityPriority();

        assertEquals(customer3, PriorityQueueQuantity.getQuantityQueueCheckout().poll());
        assertEquals(customer2, PriorityQueueQuantity.getQuantityQueueCheckout().poll());
        assertEquals(customer1, PriorityQueueQuantity.getQuantityQueueCheckout().poll());
    }


}