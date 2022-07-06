package com.qa.ims.controller;

import java.util.List;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

    public static final Logger LOGGER = LogManager.getLogger();

    private ItemDAO itemDAO;
    private Utils utils;

    public ItemController(ItemDAO itemDAO, Utils utils) {
        super();
        this.itemDAO = itemDAO;
        this.utils = utils;
    }

    /**
     * Reads all customers to the logger
     */
    @Override
    public List<Item> readAll() {
        List<Item> items = itemDAO.readAll();
        for (Item item : items) {
            LOGGER.info(item);
        }
        return items;
    }

    /**
     * Creates a customer by taking in user input
     */
    @Override
    public Item create() {
        LOGGER.info("Please enter a product name");
        String productName = utils.getString();
        LOGGER.info("Please enter a product Price");
        double productPrice = utils.getDouble();
        Item item = itemDAO.create(new Item(productName, productPrice));
        LOGGER.info("Item created");
        return item;
    }

    /**
     * Updates an existing customer by taking in user input
     */
    @Override
    public Item update() {
        LOGGER.info("Please enter the id of the item you would like to update");
        Long id = utils.getLong();
        LOGGER.info("Please enter a product name");
        String productName = utils.getString();
        LOGGER.info("Please enter a product price");
        double productPrice = utils.getDouble();
        Item item = itemDAO.update(new Item(id, productName, productPrice));
        LOGGER.info("Item updated");
        return item;
    }

    /**
     * Deletes an existing customer by the id of the customer
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the customer you would like to delete");
        Long id = utils.getLong();
        return itemDAO.delete(id);
    }

}
