package com.qa.ims.persistence.dao;


import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements Dao<Item> {


    @Override
    public List<Item> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");) {
            List<Item> item = new ArrayList<>();
            while (resultSet.next()) {
                item.add(modelFromResultSet(resultSet));
            }
            return item;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public Item read(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Item create(Item item) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO items(product_name, product_price) VALUES (?, ?)");) {
            statement.setString(1, item.getProductName());
            statement.setDouble(2, item.getProductPrice());
            statement.execute();
            return readLatest();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Item readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Item update(Item item) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE items SET product_name = ?, product_price = ? WHERE id = ?");) {
            statement.setString(1, item.getProductName());
            statement.setDouble(2, item.getProductPrice());
            statement.setLong(3, item.getId());
            statement.executeUpdate();
            return read(item.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int delete(long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getInt("id");
        String productName = resultSet.getString("product_name");
        double productPrice = resultSet.getDouble("product_price");
        return new Item(id, productName, productPrice);
    }
}
