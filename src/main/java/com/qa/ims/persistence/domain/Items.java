package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {

    private long productID;
    private String productName;

    private double productPrice;

    public Items(long productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Items(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Items() {

    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return productID == items.productID && Double.compare(items.productPrice, productPrice) == 0 && productName.equals(items.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, productPrice);
    }
}
