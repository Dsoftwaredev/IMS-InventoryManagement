package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

    private long id;
    private String productName;
    private double productPrice;

    public Item(long id, String productName, double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Item(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Double.compare(item.productPrice, productPrice) == 0 && productName.equals(item.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productPrice);
    }
}
