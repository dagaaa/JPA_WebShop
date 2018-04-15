package com.daga.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productName;
    private int unitsOnStock;
    private Double productPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUPPLIER_FK")
    private Supplier supplier;
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<ShopTransaction> transactions = new LinkedList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_FK")
    private Category category;

    public Product(String productName, int unitsOnStock, Double productPrice, Supplier supplier, Category category) {
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.productPrice = productPrice;
        this.supplier = supplier;
        this.category = category;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", unitsOnStock=" + unitsOnStock +
                ", productPrice=" + productPrice +
//                ", supplier=" + supplier.getId() +
                ", category=" + category +
                '}';
    }

    public void addTransaction(ShopTransaction transaction) {
        transactions.add(transaction);
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitsOnStock() {
        return unitsOnStock;
    }

    public void setUnitsOnStock(int unitsOnStock) {
        this.unitsOnStock = unitsOnStock;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
