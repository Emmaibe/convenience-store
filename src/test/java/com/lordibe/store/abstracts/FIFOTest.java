package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.service.ManagerServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FIFOTest {
    CustomerServices customer1 = new CustomerServices("bisola", "08084323456");
    CustomerServices customer2 = new CustomerServices("dolapo", "08084758476");
    CustomerServices customer3 = new CustomerServices("mudia", "08080987496");


    @BeforeEach
    void setUP() {
        new ManagerServices().updateStock();
        //customer1
        customer1.addToCart("tea", 6);
        customer1.addToCart("bread", 1);
        //customer2
        customer2.addToCart("goldenmorn", 2);
        customer2.addToCart("chips", 9);
        //customer3
        customer3.addToCart("bread", 30);

        //sending to priorityQueue
        customer2.checkOutFIFO();
        customer1.checkOutFIFO();
        customer3.checkOutFIFO();
    }

    @Test
    void firstInFirstOutTest() {
        assertEquals(customer2, FIFO.getQueueCheckout().poll());
        assertEquals(customer1, FIFO.getQueueCheckout().poll());
        assertEquals(customer3, FIFO.getQueueCheckout().poll());
    }
    @Test
    void managerByPassQueueTest() {
        CustomerServices customer4 = new CustomerServices("rona", "08068930219");

        //customer4
        customer4.addToCart("bread", 30);
        customer4.addToCart("toothpaste", 2);

        //using the manager to bypass the queue
        new ManagerServices().sendCustomerToQueue(customer4);

        assertEquals(customer4, FIFO.getQueueCheckout().poll());
        assertEquals(customer2, FIFO.getQueueCheckout().poll());
        assertEquals(customer1, FIFO.getQueueCheckout().poll());
        assertEquals(customer3, FIFO.getQueueCheckout().poll());
    }


}