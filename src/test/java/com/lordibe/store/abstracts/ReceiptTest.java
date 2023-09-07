package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.service.ManagerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    CustomerServices customer1 = new CustomerServices("bisola", "08084323456");

    @BeforeEach
    void setUp() {
        new ManagerServices().updateStock();

        customer1.addToCart("tea", 6);
        customer1.addToCart("bread", 1);
    }

    @Test
    void QueueForRecieptIsNotNull() {
        customer1.checkOutFIFO();
        customer1.checkOutQuantityPriority();

        assertTrue(new Receipt().issuesRecieptFIFO());
        assertTrue(new Receipt().issuesRecieptPriority());
    }

    @Test
    void QueueForRecieptIsNull() {
        assertFalse(new Receipt().issuesRecieptFIFO());
        assertFalse(new Receipt().issuesRecieptPriority());
    }
}