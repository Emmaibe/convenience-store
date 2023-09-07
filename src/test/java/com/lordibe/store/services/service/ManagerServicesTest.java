package com.lordibe.store.services.service;

import com.lordibe.store.abstracts.FIFO;
import com.lordibe.store.abstracts.enums.STAFF_TYPE;
import com.lordibe.store.model.staff.Cashier;
import com.lordibe.store.model.staff.Manager;
import com.lordibe.store.model.staff.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServicesTest {
    ManagerServices managerService = new ManagerServices();

    Manager manager = new Manager("Ibe", 35, "08062331156", "eliteibe69@gmail.com", "MSc", 200_000, STAFF_TYPE.MANAGER);
    Cashier cashier = new Cashier("Ik", 25, "08038579630", "ik@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER);
    int initialSalary = cashier.getSalary();

    @Test
    public void testHireCashierValidAge() {
        assertTrue(managerService.hireCashier("john", 27, "08037578690", "john@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER));
    }

    @Test
    public void testHireCashierInvalidAge() {
        assertFalse(managerService.hireCashier("obi", 61, "08037578690", "obi@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER));
    }

    @Test
    public void testStrike6() {
        cashier.setStrike(5); // Current strike is 5
        String result = managerService.giveStrike(cashier);
        assertEquals("cashier sacked", result);

        assertEquals(6, cashier.getStrike()); // Check strike count increment
    }

    @Test
    public void testStrike4And5() {
        cashier.setStrike(3); // Current strike is 3
        String result = managerService.giveStrike(cashier);
        assertEquals("10 % removed", result);

        assertEquals(4, cashier.getStrike()); // Check strike count increment
        assertEquals(0.9 * initialSalary, cashier.getSalary()); // Check salary deduction
    }

    @Test
    public void testStrike3() {
        cashier.setStrike(2); // Current strike is 2
        String result = managerService.giveStrike(cashier);
        assertEquals("20 % removed", result);

        assertEquals(3, cashier.getStrike()); // Check strike count increment
        assertEquals(0.8 * initialSalary, cashier.getSalary()); // Check salary deduction
    }

    @Test
    public void testDefaultStrike() {
        cashier.setStrike(0); // Current strike is 0
        String result = managerService.giveStrike(cashier);
        assertEquals("strike given", result);

        assertEquals(1, cashier.getStrike()); // Check strike count increment
    }

    @Test
    public void testDefaultStrikeSalaryUnchanged() {
        cashier.setStrike(0); // Current strike is 0
        managerService.giveStrike(cashier);

        assertEquals(initialSalary, cashier.getSalary()); // Check that salary remains unchanged
    }


    @BeforeEach
    public void setUp() {
        cashier = new Cashier("John", 25, "08038579630", "ik@gmail.com", "BSc", 100_000, STAFF_TYPE.CASHIER);
        Staff.getStaffRecordList().clear(); // Clear staff record list before each test
        Staff.getStaffList().clear(); // Clear staff list before each test
    }

    @Test
    public void testSackCashier() {
        Staff.getStaffRecordList().add(cashier); // Adds cashier object to the staff record
        Staff.getStaffList().put(cashier.getName(), cashier.getPosition()); // Adds cashier name and position to the staff map

        managerService.sackCashier(cashier); // Sack cashier method called

        assertFalse(Staff.getStaffRecordList().contains(cashier)); // Check removal of cashier object from the staff record
        assertNull(Staff.getStaffList().get(cashier.getName())); // Check removal of cashier key and value pair from the staff map
    }

    @Test
    public void testSackNonExistentCashier() {
        // Ensure the lists are empty initially
        assertTrue(Staff.getStaffRecordList().isEmpty());
        assertTrue(Staff.getStaffList().isEmpty());

        // Attempt to sack a cashier that doesn't exist
        managerService.sackCashier(cashier);

        // The lists should remain unchanged
        assertTrue(Staff.getStaffRecordList().isEmpty());
        assertTrue(Staff.getStaffList().isEmpty());
    }


    @Test
    public void testPromoteToManager() {
        managerService.promoteStaff(cashier, STAFF_TYPE.MANAGER);

        assertEquals(STAFF_TYPE.MANAGER, cashier.getPosition()); // Check position promotion
        assertEquals(200_000, manager.getSalary()); // Check salary increase
    }

    @Test
    public void testPromoteToSupervisor() {
        managerService.promoteStaff(cashier, STAFF_TYPE.SUPERVIS0R);

        assertEquals(STAFF_TYPE.SUPERVIS0R, cashier.getPosition()); // Check position promotion
        assertEquals(150_000, cashier.getSalary()); // Check salary increase
    }

    @Test
    void sendCustomerToQueueTest() {
        CustomerServices customer1 = new CustomerServices("bisola", "08084323456");
        CustomerServices customer2 = new CustomerServices("dolapo", "08084758476");
        CustomerServices customer3 = new CustomerServices("mudia", "08080987496");

        customer2.checkOutFIFO();
        customer1.checkOutFIFO();

        managerService.sendCustomerToQueue(customer3);

        assertEquals(customer3, FIFO.getQueueCheckout().peek());
    }
}