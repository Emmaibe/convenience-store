package com.lordibe.store.services.service.abstracts;

import com.lordibe.store.services.service.CustomerServices;
import com.lordibe.store.services.serviceInterface.ReceiptInterface;

import java.util.Map;

public class Receipt implements ReceiptInterface {
    @Override
    public boolean issuesReciept() {
        CustomerCart<CustomerServices, Map<String, Integer>, Integer> cartContent = FIFO.getQueueCheckout().poll();

        if (cartContent != null) {
            int totalItems = 0;
            int totalPrice = 0;

            System.out.println("=============================================");

            System.out.println("Customer's Receipt for Goods Purchased");

            System.out.println("---------------------------------------------");

            System.out.printf("Customer's Name: %s\n", cartContent.getCUSTOMER().getName());

            System.out.println("---------------------------------------------");

            System.out.printf("%-10s %-10s %-10s %-10s\n","Items","Quantity","Unit-Price","Total");

            System.out.println("---------------------------------------------");

            for (String key : cartContent.getCUSTOMER_CART().keySet()) {
                System.out.printf("%-10s %-10s %-10s %-10s\n", key,cartContent.getCUSTOMER_CART().get(key), Check.checkStock(key).get(key).getProductPrice(),(cartContent.getCUSTOMER_CART().get(key) * Check.checkStock(key).get(key).getProductPrice()));
                totalItems += cartContent.getCUSTOMER_CART().get(key);
                totalPrice += (cartContent.getCUSTOMER_CART().get(key) * Check.checkStock(key).get(key).getProductPrice());
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
