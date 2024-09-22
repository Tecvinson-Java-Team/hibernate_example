package com.tecvisonacademy.dao;


import com.tecvisonacademy.entities.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAO {

    private final Session session;

    public CustomerDAO(Session session) {
        this.session = session;
    }

    //Method to select all customers
    public List<Customer> selectAllCustomers()
    {
        return session.createQuery("FROM Customer", Customer.class).list();
    }

    //Method to update customer
    public void updateCustomer(Customer customer)
    {
        session.update(customer);
    }


}
