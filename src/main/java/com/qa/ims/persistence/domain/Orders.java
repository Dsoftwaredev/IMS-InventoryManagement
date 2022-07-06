package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Orders {

    private long orderID;
    private long custID;
    private long ItemID;


    public Orders(long custID, long itemID) {
        this.custID = custID;
        ItemID = itemID;
    }

    public Orders(long orderID, long custID, long itemID) {
        this.orderID = orderID;
        this.custID = custID;
        ItemID = itemID;
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

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", custID=" + custID +
                ", ItemID=" + ItemID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderID == orders.orderID && custID == orders.custID && ItemID == orders.ItemID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, custID, ItemID);
    }
}
