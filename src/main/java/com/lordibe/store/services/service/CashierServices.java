package com.lordibe.store.services.service;

import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Staff;
import com.lordibe.store.services.serviceInterface.CashierServiceInterface;
import com.lordibe.store.abstracts.Receipt;

import java.util.Set;

public class CashierServices implements CashierServiceInterface {
    @Override
    public void issuesReceipt(Cashier cashier) {
        Set<String> names = Staff.getStaffList().keySet();
        if (names.contains(cashier.getName())) {
            Receipt receipt = new Receipt();
            boolean state = receipt.issuesReciept();

            if (state != false) {
                System.out.println("Thanks for your patronage, Have a nice day...");
                System.out.println("=============================================");
                System.out.printf("Receipt issued by :   %s\n", cashier.getName());
                System.out.println("Stock Synchronized");
                System.out.println("=============================================");
            } else {
                System.out.println("The Queue is empty");
            }

        } else {
            System.out.println("This cashier cannot issue a reciept as He or She is no longer with us...");
        }
    }
}
