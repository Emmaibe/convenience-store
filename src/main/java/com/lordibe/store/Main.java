package com.lordibe.store;

import com.lordibe.store.abstracts.PriorityQueueQuantity;
import com.lordibe.store.model.product.Stock;
import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Manager;
import com.lordibe.store.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.services.service.CashierServices;
import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.service.ManagerServices;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        //NEW CHANGES MADE IN WEEK 3.

        //Stock object
        Stock stock = new Stock();

        //Manager object.
        Manager manager = new Manager("Ibe", 35, "08062331156", "eliteibe69@gmail.com", "MSc", 200_000, STAFF_TYPE.MANAGER);

        //Manager Service object.
        ManagerServices managerServices = new ManagerServices();


        //Cashier Objects.
        Cashier cashier1 = new Cashier("Emmanuel", 25, "08038579630", "ik@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER);
        Cashier cashier2 = new Cashier("Pascal", 28, "08064656306", "voke@gmail.com", "School Cert", 100_000, STAFF_TYPE.CASHIER);

        //Cashier Service object.
        CashierServices cashierService = new CashierServices();

        //Customer Service object.
        CustomerServices customer1 = new CustomerServices("Francis", "08094577448");
        CustomerServices customer2 = new CustomerServices("Juliet", "09044758926");
        CustomerServices customer3 = new CustomerServices("Samuel", "08189027644");
        CustomerServices customer4 = new CustomerServices("Abigail", "07084902466");
        CustomerServices customer5 = new CustomerServices("Lucky", "09057309756");
        CustomerServices customer6 = new CustomerServices("Stanley", "08085023176");



        //IMPLEMENTING VARIOUS METHODS

        //Manager Services
        managerServices.updateStock();

        //CUSTOMER SERVICES
        //Customer1 adding to his cart
        customer1.addToCart("Bread", 10);
        customer1.addToCart("pringles", 5);
        customer1.addToCart("torchLight", 2);
        customer1.addToCart("GoldenMorn", 5);
        customer1.addToCart("GoldenMorn", 5);
        customer1.addToCart("sanitizers", 3);
        customer1.addToCart("Tea", 10);
        customer1.addToCart("vodka", 6);

        System.out.println();

        customer1.viewCart(); //Customer1 viewing his cart.

        System.out.println();

        //Customer2 adding to her cart
        customer2.addToCart("Tea", 5);
        customer2.addToCart("Pringles", 10);
        customer2.addToCart("Gin", 5);

        System.out.println();

        customer2.viewCart(); //Customer2 viewing her cart.

        System.out.println();

        //Customer3 adding to his cart
        customer3.addToCart("Batteries", 20);
        customer3.addToCart("muffins", 10);
        customer3.addToCart("Whiskey", 5);
        customer3.addToCart("Detergent", 9);
        customer3.addToCart("Yogurt", 10);

        System.out.println();

        customer3.viewCart(); //Customer3 viewing his cart.

        System.out.println();

        //Customer4 adding to her cart
        customer4.addToCart("Protein bars", 2);
        customer4.addToCart("Coffee", 3);
        customer4.addToCart("Sponges", 1);
        customer4.addToCart("Toothpaste", 2);
        customer4.addToCart("Eggs", 2);

        System.out.println();

        customer4.viewCart(); //Customer4 viewing her cart.

        System.out.println();

        //Customer5 adding to his cart
        customer5.addToCart("Pringles", 50);
        customer5.addToCart("Surge", 80);

        System.out.println();

        customer5.viewCart(); //Customer5 viewing his cart.

        System.out.println();

        //Customer6 adding to his cart
        customer6.addToCart("supplements", 2);
        customer6.addToCart("Tequila", 1);

        System.out.println();

        customer6.viewCart(); //Customer6 viewing his cart.

        System.out.println();

        //Customers placed on a Queue (FIFO)
        customer2.checkOutFIFO();
        customer5.checkOutFIFO();
        customer1.checkOutFIFO();
        customer4.checkOutFIFO();
        customer3.checkOutFIFO();
        managerServices.sendCustomerToQueue(customer6); /*Any Customer sent to the queue by
                                                          Manager at any point in time, will
                                                          be attended to First (will be given
                                                          the utmost priority)*/

        //Customers placed on a Priority Queue based on the total quantity of goods
        //(Customer with the largest Quantity will be attended to first)
        customer1.checkOutQuantityPriority();
        customer2.checkOutQuantityPriority();
        customer3.checkOutQuantityPriority();
        customer4.checkOutQuantityPriority();
        customer5.checkOutQuantityPriority();
        customer6.checkOutQuantityPriority();

        System.out.println();


        //Cashier Service

        //Receipt based on FIFO
//        cashierService.issuesReceiptFIFO(cashier1);
//
//        System.out.println();
//
//        cashierService.issuesReceiptFIFO(cashier2);
//
//        System.out.println();
//
//        cashierService.issuesReceiptFIFO(cashier1);
//
//        System.out.println();
//
//        cashierService.issuesReceiptFIFO(cashier2);
//
//        System.out.println();
//
//        cashierService.issuesReceiptFIFO(cashier1);
//
//        System.out.println();
//
//        cashierService.issuesReceiptFIFO(cashier2);
//
//        System.out.println();

        //Receipt issue base on PriorityQueue (Quantity of goods bought)
        cashierService.issuesReceiptPriority(cashier1);

        System.out.println();

        cashierService.issuesReceiptPriority(cashier2);

        System.out.println();

        cashierService.issuesReceiptPriority(cashier1);

        System.out.println();

        cashierService.issuesReceiptPriority(cashier2);

        System.out.println();

        cashierService.issuesReceiptPriority(cashier1);

        System.out.println();

        cashierService.issuesReceiptPriority(cashier2);
    }
}