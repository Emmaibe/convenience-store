package com.lordibe.store.services.serviceInterface;

import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.services.service.CustomerServices;

public interface CashierServiceInterface {
    public String issuesReceiptFIFO(Cashier cashier);
    public String issuesReceiptPriority(Cashier cashier);
}
