package com.lordibe.store.model.staff;

import com.lordibe.store.abstracts.enums.STAFF_TYPE;

import java.util.*;

public abstract class Staff {
    private static List<Staff> staffRecord = new ArrayList<>();
    private static Map<String, STAFF_TYPE> staffList = new HashMap<>();
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private String certificate;
    private int salary;
    private STAFF_TYPE position;

    public Staff(String name, int age, String phoneNumber, String email, String certificate, int salary, STAFF_TYPE position) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.certificate = certificate;
        this.salary = salary;
        this.position = position;
    }

    public static Map<String, STAFF_TYPE> getStaffList() {
        return staffList;
    }

    public static void setStaffList(String name, STAFF_TYPE type) {
        staffList.put(name, type);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCertificate() {
        return certificate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public STAFF_TYPE getPosition() {
        return position;
    }

    public void setPosition(STAFF_TYPE position) {
        this.position = position;
    }

    public static List<Staff> getStaffRecordList() {
        return staffRecord;
    }

    public static void getStaffRecords() {
        for (Staff staff : staffRecord) {
                System.out.printf("%-10s %-10s %-10s %-10s %-10s", staff.getPosition(), staff.getName(),staff.getAge(), staff.getPhoneNumber(), staff.getSalary());
        }
    }
}
