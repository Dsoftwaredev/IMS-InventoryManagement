package com.qa.ims.controller;

import java.util.List;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Orders> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrdersDAO ordersDAO;
    private Utils utils;

    public OrderController(OrdersDAO ordersDAO, Utils utils) {
        super();
        this.ordersDAO = ordersDAO;
        this.utils = utils;
    }

    /**
     * Reads all customers to the logger
     */
    @Override
    public List<Orders> readAll() {
        List<Orders> orders = ordersDAO.readAll();
        for (Orders order : orders) {
            LOGGER.info(orders);
        }
        return orders;
    }

    /**
     * Creates a customer by taking in user input
     */
    @Override
    public Orders create() {
        LOGGER.info("Please enter a customer id");
        long custID = utils.getLong();
        LOGGER.info("Please enter a Item id");
        long ItemID = utils.getLong();
        Orders orders = ordersDAO.create(new Orders(custID, ItemID));
        LOGGER.info("Order");
        return orders;
    }

    /**
     * Updates an existing customer by taking in user input
     */
    @Override
    public Orders update() {
        LOGGER.info("Please enter the id of the order you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter a product name");
        long custID = utils.getLong();
        LOGGER.info("Please enter a product price");
        long ItemID = utils.getLong();
        Orders orders = ordersDAO.update(new Orders(id, custID, ItemID));
        LOGGER.info("Item updated");
        return orders;
    }

    /**
     * Deletes an existing customer by the id of the customer
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the order you would like to delete");
        Long id = utils.getLong();
        return ordersDAO.delete(id);
    }

}
