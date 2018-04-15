package com.daga.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Category {
    private String name;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private List<Product> products = new LinkedList<>();
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    private int categoryID;

    public Category() {
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return name
                ;
    }
}
