package com.lordibe.store.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.serviceInterface.ReceiptInterface;

public class Receipt implements ReceiptInterface {
    @Override
    public boolean issuesReciept() {
        CustomerServices customerService = FIFO.getQueueCheckout().poll();

        if (customerService != null) {
            int totalItems = 0;
            int totalPrice = 0;

            System.out.println("=============================================");

            System.out.println("Customer's Receipt for Goods Purchased");

            System.out.println("---------------------------------------------");

            System.out.printf("Customer's Name: %s\n", customerService.getName());

            System.out.println("---------------------------------------------");

            System.out.printf("%-10s %-10s %-10s %-10s\n","Items","Quantity","Unit-Price","Total");

            System.out.println("---------------------------------------------");

            for (String key : customerService.getCartContent().keySet()) {
                System.out.printf("%-10s %-10s %-10s %-10s\n", key, customerService.getCartContent().get(key), Check.checkStock(key).get(key).getProductPrice(),(customerService.getCartContent().get(key) * Check.checkStock(key).get(key).getProductPrice()));
                totalItems += customerService.getCartContent().get(key);
                totalPrice += (customerService.getCartContent().get(key) * Check.checkStock(key).get(key).getProductPrice());
            }

            System.out.println("---------------------------------------------");

            System.out.printf("Total" + "     :   " + totalItems + "    :   " + "------" + "  :   " + "#" + totalPrice + "\n");

            System.out.println("---------------------------------------------");

            //Synchronize Stock.csv file with current stock
            Updates.syncStock();
        }
        else {
            return false;
        }
        return true;
    }
}
