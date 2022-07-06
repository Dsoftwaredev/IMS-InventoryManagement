package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Orders {

    private long orderID;
    private long custID;
    private long ItemID;
    private double cost;

    public Orders(long orderID, long custID, long itemID, double cost) {
        this.orderID = orderID;
        this.custID = custID;
        ItemID = itemID;
        this.cost = cost;
    }

    public Orders(long custID, long itemID, double cost) {
        this.custID = custID;
        ItemID = itemID;
        this.cost = cost;
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

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", custID=" + custID +
                ", ItemID=" + ItemID +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderID == orders.orderID && custID == orders.custID && ItemID == orders.ItemID && Double.compare(orders.cost, cost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, custID, ItemID, cost);
    }
}
