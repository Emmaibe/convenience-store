package com.lordibe.store.services.service;

import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Staff;
import com.lordibe.store.services.serviceInterface.CashierServiceInterface;
import com.lordibe.store.abstracts.Receipt;

import java.util.Set;

public class CashierServices implements CashierServiceInterface {
    @Override
    public String issuesReceiptFIFO(Cashier cashier) {
        Set<String> names = Staff.getStaffList().keySet();
        if (names.contains(cashier.getName())) {
            Receipt receipt = new Receipt();
            boolean state = receipt.issuesRecieptFIFO();

            if (state) {
                System.out.println("Thanks for your patronage, Have a nice day...");
                System.out.println("=============================================");
                System.out.printf("Receipt issued by :   %s\n", cashier.getName());
                System.out.println("Stock Synchronized");
                System.out.println("=============================================");
                return "issued";
            } else {
                System.out.println("The Queue is empty");
                return "empty queue";
            }

        } else {
            System.out.println("This cashier cannot issue a reciept as He or She is no longer with us...");
            return "invalid Cashier";
        }
    }

    public String issuesReceiptPriority(Cashier cashier) {
        Set<String> names = Staff.getStaffList().keySet();
        if (names.contains(cashier.getName())) {
            Receipt receipt = new Receipt();
            boolean state = receipt.issuesRecieptPriority();

            if (state != false) {
                System.out.println("Thanks for your patronage, Have a nice day...");
                System.out.println("=============================================");
                System.out.printf("Receipt issued by :   %s\n", cashier.getName());
                System.out.println("Stock Synchronized");
                System.out.println("=============================================");
                return "issued";
            } else {
                System.out.println("The Queue is empty");
                return "empty queue";
            }

        } else {
            System.out.println("This cashier cannot issue a reciept as He or She is no longer with us...");
            return "invalid Cashier";
        }
    }
}
