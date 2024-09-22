package com.tecvisonacademy.entities;


import javax.persistence.*;

@org.hibernate.annotations.Table(appliesTo = "inventory", comment ="MySQL engine = InnoDB")
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "stock", nullable = false)
    private int stock;

    public  Inventory(){}

    public Inventory(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
