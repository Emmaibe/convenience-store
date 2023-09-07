package com.lordibe.store.services.service;

import com.lordibe.store.abstracts.FIFO;
import com.lordibe.store.abstracts.PriorityQueueQuantity;
import com.lordibe.store.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.model.staff.Cashier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierServicesTest {
    ManagerServices managerServices = new ManagerServices();
    CashierServices cashierServices = new CashierServices();
    Cashier cashier = new Cashier("nedu", 30, "09175847384", "nedu@yahoo.com", "BSc", 150000, STAFF_TYPE.CASHIER);

    CustomerServices customer1 = new CustomerServices("chisom", "08093840572");
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
    }

    @AfterEach
    void setUp() {
        FIFO.getQueueCheckout().clear();
        PriorityQueueQuantity.getQuantityQueueCheckout().clear();
    }

    @Test
    void issueReceiptFIFOTest() {
        customer1.checkOutFIFO();

        assertEquals("issued", cashierServices.issuesReceiptFIFO(cashier));
    }

    @Test
    void issueReceiptPriorityQueueTest() {
        customer2.checkOutQuantityPriority();

        assertEquals("issued", cashierServices.issuesReceiptPriority(cashier));
    }

    @Test
    void emptyFIFOQueueReceiptNotIssued() {
        assertEquals("empty queue", cashierServices.issuesReceiptFIFO(cashier));
    }

    @Test
    void emptyPriorityQueueReceiptNotIssued() {
        assertEquals("empty queue", cashierServices.issuesReceiptPriority(cashier));
    }

    @Test
    void invalidCashierFIFOQueueTest() {
        customer2.checkOutFIFO();

        managerServices.sackCashier(cashier);

        assertEquals("invalid Cashier", cashierServices.issuesReceiptFIFO(cashier));
    }

    @Test
    void invalidCashierQuantityPriorityQueueTest() {
        customer2.checkOutQuantityPriority();

        managerServices.sackCashier(cashier);

        assertEquals("invalid Cashier", cashierServices.issuesReceiptPriority(cashier));
    }
}