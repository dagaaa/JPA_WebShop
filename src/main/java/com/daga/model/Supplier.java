package com.daga.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;


    private String street;
    private String zipCode;
    private String city;
    @OneToMany(mappedBy = "supplier", cascade = {CascadeType.ALL})
    private List<Product> products = new LinkedList<>();

    public Supplier() {
    }

    public long getId() {
        return id;
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

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", products=" + products +
                '}';
    }


}
