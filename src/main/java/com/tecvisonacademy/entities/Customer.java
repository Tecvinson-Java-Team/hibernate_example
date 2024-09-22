package com.tecvisonacademy.entities;



import javax.persistence.*;

@org.hibernate.annotations.Table(appliesTo = "customers", comment ="MySQL engine = InnoDB")
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="customer_id", nullable = false)
    private int customerId;

    @Column(name ="customer_name", nullable = false)
    private String customerName;

    @Column(name ="balance", nullable = false)
    private double balance;

    public Customer()
    {}


    public Customer(String customerName, double balance)
    {
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
