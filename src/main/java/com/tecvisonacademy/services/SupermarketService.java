package com.tecvisonacademy.services;

import com.tecvisonacademy.dao.SuperMarketDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupermarketService {
    private final SuperMarketDAO superMarketDAO;
    private final Session session;

    public SupermarketService(Session session) {
        this.superMarketDAO = new SuperMarketDAO(session);
        this.session = session;
    }

    public void executeTransaction()
    {
        Transaction transaction = session.beginTransaction();

        try {

            //Deduct Stock
            superMarketDAO.deductStock(10, 1); //Update Laptop

            //Insert into order History
            superMarketDAO.insertOrderHistory(1,20,1);


            //Update Payment
            boolean paymentSuccessful =  false;

            try
            {
              superMarketDAO.updateCustomerBalance(500, 1);
              paymentSuccessful = true;
            }catch (Exception e)
            {
               transaction.rollback(); //Rollback on failure
                System.out.println("Rolled back due to error "+ e.getMessage());
            }

            if(paymentSuccessful)
            {
                transaction.commit();
                System.out.println("Transaction commited successfully");
            }
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Rolled back due to error "+ e.getMessage());
        }
    }
}
