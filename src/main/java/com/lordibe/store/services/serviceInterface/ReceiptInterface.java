package com.lordibe.store.services.serviceInterface;

import com.lordibe.store.services.service.CustomerServices;

public interface ReceiptInterface {
//    public int getProductPrice(Products price);

    public boolean issuesRecieptFIFO();
    public boolean issuesRecieptPriority();
}
