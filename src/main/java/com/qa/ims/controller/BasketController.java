package com.qa.ims.controller;

import com.qa.ims.persistence.dao.BasketDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Basket;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BasketController implements CrudController<Basket>{
    public static final Logger LOGGER = LogManager.getLogger();

    private BasketDAO basketDAO;
    private Utils utils;

    public BasketController(BasketDAO basketDAO, Utils utils) {
        this.basketDAO = basketDAO;
        this.utils = utils;
    }

    //works
    @Override
    public List<Basket> readAll() {
        List<Basket> basket = basketDAO.readAll();
        for (Basket baskets : basket) {
            LOGGER.info(baskets);
        }
        return basket;
    }

    //works
    @Override
    public Basket create() {
        LOGGER.info("Please enter a item id");
        long itemid = utils.getLong();
        LOGGER.info("Please enter a Order id");
        long orderid = utils.getLong();
        LOGGER.info("please enter your quantity");
        long quantity = utils.getLong();
        LOGGER.info("Plesae enter a price");
        double price = utils.getDouble();
        Basket basket = basketDAO.create(new Basket(itemid, orderid, quantity, price));
        LOGGER.info("Order");
        return basket;
    }

    @Override
    public Basket update() {
        LOGGER.info("enter your basket id");
        long basket = utils.getLong();
        LOGGER.info("What is the ID of the order that you want to add an item from");
        Long Orderid = utils.getLong();
        LOGGER.info("What is the id of the item that you would like to add to the order");
        Long Itemid = utils.getLong();
        LOGGER.info("please enter your quantity");
        long quantity = utils.getLong();
        LOGGER.info("Plesae enter a price");
        double price = utils.getDouble();

        Basket basketItem = basketDAO.update(new Basket(basket, Itemid, Orderid, quantity,price));
            LOGGER.info("Item added to the order");
            return basketItem;

    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the order you would like to delete");
        Long id = utils.getLong();
        return basketDAO.delete(id);
    }
}
