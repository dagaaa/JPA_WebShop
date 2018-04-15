package com.daga.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ShopTransaction {
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_FK")
    private Customer customer;
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private int transactionNumber;
    @ManyToMany(mappedBy = "transactions", cascade = {CascadeType.ALL})
    private List<Product> products = new LinkedList<>();

    public ShopTransaction() {
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder x = new StringBuilder();
        for (Product p : products)
            x.append(p.getProductName()).append(", ");
        return "ShopTransaction{" +
                "quantity=" + quantity +
                ", transactionNumber=" + transactionNumber +
                ", products=" + x +
                '}';
    }
}
