package com.lordibe.store.services.serviceInterface;

import com.lordibe.store.services.service.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Staff;

public interface ManagerServiceInterface {
    void updateStock();
    boolean hireCashier(String name, int age, String phoneNumber, String email, String certificate, int salary, STAFF_TYPE position);
    void deductSalary(Cashier cashier, int amount);
    void promoteStaff(Cashier cashier, STAFF_TYPE position);
    void increaseSalary(Cashier cashier, int amount);
    void getStaffRecord(Staff staff);
    void getStaffsRecord();
    String giveStrike(Cashier cashier);
    boolean sackCashier(Cashier name);
    void checkStock();
}
