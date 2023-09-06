package com.lordibe.store.services.serviceInterface;

import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.services.service.CustomerServices;

public interface CashierServiceInterface {
    public void issuesReceiptFIFO(Cashier cashier);
    public void issuesReceiptPriority(Cashier cashier);
}
