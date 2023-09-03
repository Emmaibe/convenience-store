package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.serviceInterface.ReceiptInterface;

import java.util.Map;

public class Receipt implements ReceiptInterface {
    @Override
    public boolean issuesReciept(CustomerServices customerServices) {
        Map<String, Integer> cartContent = FIFO.getQueueCheckout().poll();

        if (cartContent != null) {
            int totalItems = 0;
            int totalPrice = 0;

            System.out.println("=============================================");

            System.out.println("Customer's Receipt for Goods Purchased");

            System.out.println("---------------------------------------------");

            System.out.printf("Customer's Name: %s\n", customerServices.getName());

            System.out.println("---------------------------------------------");

            System.out.printf("%-10s %-10s %-10s %-10s\n","Items","Quantity","Unit-Price","Total");

            System.out.println("---------------------------------------------");

            for (String key : cartContent.keySet()) {
                System.out.printf("%-10s %-10s %-10s %-10s\n", key,cartContent.get(key), Check.checkStock(key).get(key).getProductPrice(),(cartContent.get(key) * Check.checkStock(key).get(key).getProductPrice()));
                totalItems += cartContent.get(key);
                totalPrice += (cartContent.get(key) * Check.checkStock(key).get(key).getProductPrice());
            }

            System.out.println("---------------------------------------------");

            System.out.printf("Total" + "     :   " + totalItems + "    :   " + "------" + "  :   " + "#" + totalPrice + "\n");

            System.out.println("---------------------------------------------");

            //Synchronize Stock.csv file with current stock
            Updates.syncStock();

            System.out.printf("Receipt Issued to %s, and Stock Synchronized\n", customerServices.getName());
        }
        else {
            return false;
        }
        return true;
    }
}
