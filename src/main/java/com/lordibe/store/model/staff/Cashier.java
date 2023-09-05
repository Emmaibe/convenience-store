package com.lordibe.store.model.staff;

import com.lordibe.store.abstracts.enums.STAFF_TYPE;

public class Cashier extends Staff {
    private int strike = 0;
    public Cashier(String name, int age, String phoneNumber, String email, String certificate, int salary, STAFF_TYPE position) {
        super(name, age, phoneNumber, email, certificate, salary, position);
        Staff.getStaffRecordList().add(this);
        setStaffList(this.getName(), this.getPosition());
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
