package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Orders {

    private long orderID;
    private long custID;
    private long ItemID;
    private double cost;
    private ArrayList<Item> products;

    /*public double totalCost() {
        double total = 0;
        for (Item items : products) {
            total +=  items.getProductPrice();
        }
         cost = total;
        return total;

    }*/

    public Orders(long custID, long itemID) {
        this.custID = custID;
        ItemID = itemID;
    }

    public Orders(long orderID, long custID, long itemID) {
        this.orderID = orderID;
        this.custID = custID;
        ItemID = itemID;
    }

    public Orders(long orderID, long custID, long itemID, double cost, ArrayList<Item> products) {
        this.orderID = orderID;
        this.custID = custID;
        ItemID = itemID;
        this.cost = cost;
        this.products = products;
    }

    public Orders(long orderID) {
        this.orderID = orderID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getCustID() {
        return custID;
    }

    public void setCustID(long custID) {
        this.custID = custID;
    }

    public long getItemID() {
        return ItemID;
    }

    public void setItemID(long itemID) {
        ItemID = itemID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public ArrayList<Item> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Item> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderID == orders.orderID && custID == orders.custID && ItemID == orders.ItemID && Double.compare(orders.cost, cost) == 0 && Objects.equals(products, orders.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, custID, ItemID, cost, products);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", custID=" + custID +
                ", ItemID=" + ItemID +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
