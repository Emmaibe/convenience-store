package com.lordibe.store.model.staff;

import com.lordibe.store.abstracts.enums.STAFF_TYPE;

public class Manager extends Staff {
    public Manager(String name, int age, String phoneNumber, String email, String certificate, int salary, STAFF_TYPE position) {
        super(name, age, phoneNumber, email, certificate, salary, position);
        Staff.getStaffRecordList().add(this);
        setStaffList(this.getName(), this.getPosition());
    }
}
