package com.tecvisonacademy;

import com.tecvisonacademy.entities.Customer;
import com.tecvisonacademy.services.CustomerService;
import com.tecvisonacademy.services.SupermarketService;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        SupermarketService supermarketService = new SupermarketService(session);
        supermarketService.executeTransaction();

        /*CustomerService customerService = new CustomerService(session);

        //Fetch All Customers
        List<Customer> customers = customerService.fetchAllCustomer();
        customers.forEach(
                customer -> System.out.println("Customer Name: " + customer.getCustomerName() + "Balance: " + customer.getBalance()
        ));


        if(!customers.isEmpty())
        {
            Customer customerToUpdate = customers.get(0); //get first customer
            customerToUpdate.setBalance(50000.00);
            customerToUpdate.setCustomerName("Richard");
            customerService.modifyCustomer(customerToUpdate);
        }
        */








    }
}