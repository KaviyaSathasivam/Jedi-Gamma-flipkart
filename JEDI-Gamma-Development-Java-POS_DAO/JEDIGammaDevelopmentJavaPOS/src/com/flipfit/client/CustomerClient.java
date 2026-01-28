package com.flipfit.client;

import com.flipfit.dao.CustomerDao;

public class CustomerClient {
    public static void main(String[] args) {
        CustomerDao manager = new CustomerDao();

        // Perform CRUD operations
        manager.insertCustomer(101,"Alice Smith", "alice@example.com", "1234567890");
        manager.insertCustomer(102,"Bob Jones", "bob@example.com", "0987654321");

        manager.selectAllCustomers();

        manager.updateCustomerContact(101, "1112223333");

        manager.selectAllCustomers();

        manager.deleteCustomer(102);

        manager.selectAllCustomers();
    }
}
