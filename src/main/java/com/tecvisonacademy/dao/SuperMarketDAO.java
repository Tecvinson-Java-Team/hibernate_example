package com.tecvisonacademy.dao;

import com.tecvisonacademy.entities.Customer;
import com.tecvisonacademy.entities.Inventory;
import com.tecvisonacademy.entities.OrderHistory;
import org.hibernate.Session;

public class SuperMarketDAO {


    private Session session;

    public SuperMarketDAO(Session session)
    {
        this.session = session;
    }

    public void deductStock(int stock, int itemId)
    {
        Inventory inventory = session.get(Inventory.class, itemId);
        if(inventory != null)
        {
            inventory.setStock(inventory.getStock() - stock);
            session.update(inventory);
        }
    }

    public void insertOrderHistory(int itemId, int quantity, int customerId)
    {
        Inventory inventory = session.get(Inventory.class, itemId);
        Customer customer = session.get(Customer.class, customerId);

        if(inventory != null && customer != null)
        {
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.setItem(inventory);
            orderHistory.setQuantity(quantity);
            orderHistory.setCustomer(customer);

            session.save(orderHistory);

        }else
        {
            System.out.println("Inventory or Customer not found.");
        }

    }

    public void updateCustomerBalance(double amount, int customerId)
    {
        Customer customer = session.get(Customer.class, customerId);

        if(customer != null)
        {
            customer.setBalance(customer.getBalance() - amount);
            session.update(customer);
        }
    }
}
