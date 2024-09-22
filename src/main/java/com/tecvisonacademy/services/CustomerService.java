package com.tecvisonacademy.services;

import com.tecvisonacademy.dao.CustomerDAO;
import com.tecvisonacademy.entities.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO;
    private final Session session;

    public CustomerService(Session session) {
        this.customerDAO = new CustomerDAO(session);
        this.session = session;
    }

    //Method to select all customers
    public List<Customer> fetchAllCustomer()
    {
        return customerDAO.selectAllCustomers();
    }

    //Method to update a customer
    public void modifyCustomer(Customer customer)
    {
        //Start transaction
        Transaction transaction = session.beginTransaction();

        try {
            customerDAO.updateCustomer(customer);
            transaction.commit();
            System.out.println("Customer update successfully");
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Failed to update customer");
        }


    }
}
