package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private long id;
    private Long itemid;
    private Long orderid;
    private Long quantity;
    private double price;

    private double cost;


    public Basket(Long itemid, Long orderid, Long quantity, double price) {
        this.itemid = itemid;
        this.orderid = orderid;
        this.quantity = quantity;
        this.price = price;
    }



    public double getCost() {
        this.cost = this.price * this.quantity;
        return this.cost;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", itemid=" + itemid +
                ", orderid=" + orderid +
                ", quantity=" + quantity +
                ", price=" + price +
                ", cost=" + getCost() +
                '}';
    }

    public Basket(long id, Long itemid, Long orderid, Long quantity, double price) {
        this.id = id;
        this.itemid = itemid;
        this.orderid = orderid;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Double.compare(basket.price, price) == 0 && Objects.equals(itemid, basket.itemid) && Objects.equals(orderid, basket.orderid) && Objects.equals(quantity, basket.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemid, orderid, quantity, price);
    }
}
