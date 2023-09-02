package com.lordibe.store.services.service;

import com.lordibe.store.model.product.Stock;
import com.lordibe.store.services.service.abstracts.enums.PRODUCT_CATEGORY;
import com.lordibe.store.services.service.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Staff;
import com.lordibe.store.services.serviceInterface.ManagerServiceInterface;
import com.lordibe.store.services.service.abstracts.Updates;

import java.sql.SQLOutput;

public class ManagerServices implements ManagerServiceInterface {
    public void addToStock (String productName, int productPrice, PRODUCT_CATEGORY PRODUCTCATEGORY, int qntyOfProduct) {
        Updates.updateStockFile(productName.toLowerCase(), productPrice, PRODUCTCATEGORY, qntyOfProduct);
    }

    @Override
    public void updateStock() {
        new Stock().addToStock();
    }

    @Override
    public String giveStrike(Cashier cashier) {
        cashier.setStrike(cashier.getStrike() + 1);
        switch (cashier.getStrike()) {
            case 6 -> {
                this.sackCashier(cashier);
                return "cashier sacked";
            }
            case 4, 5 -> {
                this.deductSalary(cashier, (int) (0.1 * cashier.getSalary()));
                return "10 % removed";
            }
            case 3 -> {
                this.deductSalary(cashier, (int) (0.2 * cashier.getSalary()));
                return "20 % removed";
            }
        }
        return "strike given";
    }

    @Override
    public boolean sackCashier(Cashier name) {
        if (Staff.getStaffRecordList().contains(name)) {
            Staff.getStaffRecordList().remove(name);
            Staff.getStaffList().remove(name.getName());
            System.out.printf("Cashier %s has been sacked by Manager.\n", name.getName());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void checkStock() {
        new Stock().viewTotalStock();
    }

    @Override
    public boolean hireCashier(String name, int age, String phoneNumber, String email, String certificate, int salary, STAFF_TYPE position) {
        if (age > 17 && age < 60) {
            Cashier newCashier = new Cashier(name, age, phoneNumber, email, certificate, salary, position);
            System.out.printf("%s has been hired as a %s.\n", name, position);
            return true;
        } else {
            System.out.printf("%s can't be hired, Bio does not meet requirement.\n", name);
            return false;
        }
    }

    @Override
    public void deductSalary(Cashier cashier, int amount) {
        cashier.setSalary(cashier.getSalary() - amount);
    }

    @Override
    public void promoteStaff(Cashier cashier, STAFF_TYPE position) {
        cashier.setPosition(position);
        this.increaseSalary(cashier, (int) (0.5 * cashier.getSalary()));
    }

    @Override
    public void increaseSalary(Cashier cashier, int amount) {
        cashier.setSalary(cashier.getSalary() + amount);
    }

    @Override
    public void getStaffRecord(Staff staff) {
        if (Staff.getStaffList().keySet().contains(staff.getName())){
            System.out.println(staff.getPosition() + " : " + staff.getName() + " : " + staff.getAge() + " : " + staff.getPhoneNumber() + " : " + staff.getSalary() + " : " + staff.getEmail() + " : " + staff.getCertificate());
        } else {
            System.out.printf("%s is no Longer with us\n", staff.getName());
        }
    }

    public void getStaffsRecord() {
        Staff.getStaffRecords();
    }
}
