package com.daga.model;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    private String firstName;
    private String lastName;
    private float discount;
    private String street;
    private String city;
    private String zipCode;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private List<ShopTransaction> shopTransactions = new LinkedList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, float discount, String street, String city, String zipCode) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.discount = discount;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", discount=" + discount +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void addTransaction(ShopTransaction transaction) {
        shopTransactions.add(transaction);
    }
}
