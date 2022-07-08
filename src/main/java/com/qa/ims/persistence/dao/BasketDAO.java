package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Basket;
import com.qa.ims.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketDAO implements Dao<Basket> {
    @Override
    public Basket modelFromResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getInt("basket_id");
        long itemid = resultSet.getInt("items_id");
        long orderid = resultSet.getInt("orders_id");
        long quantity = resultSet.getInt("quantity");
        double price = resultSet.getDouble("total_cost");
        return new Basket(id, itemid, orderid, quantity, price);
    }

    @Override
    public List<Basket> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM basket");) {
            List<Basket> basket = new ArrayList<>();
            while (resultSet.next()) {
                basket.add(modelFromResultSet(resultSet));
            }
            return basket;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public Basket read(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM basket WHERE basket_id = ?");) {
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

    public Basket readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM basket ORDER BY basket_id DESC LIMIT 1");) {
            resultSet.next();
            long itemid = resultSet.getInt("items_id");
            long orderid = resultSet.getInt("orders_id");
            long quantity = resultSet.getInt("quantity");
            double price = resultSet.getDouble("total_cost");
            return new Basket(itemid, orderid, quantity, price);

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    @Override
    public Basket create(Basket basket) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO basket (orders_id, items_id, quantity, total_cost) VALUES (?, ?, ?, ?)");) {
            statement.setLong(1, basket.getOrderid());
            statement.setLong(2, basket.getItemid());
            statement.setLong(3, basket.getQuantity());
            statement.setDouble(4, basket.getPrice());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            System.out.println(e);
        }
        return basket;
    }

    @Override
    public Basket update(Basket basket) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE basket SET orders_id = ?, items_id = ?, quantity = ?, total_cost = ? WHERE basket_id = ?");) {
            statement.setLong(1, basket.getOrderid());
            statement.setLong(2, basket.getItemid());
            statement.setLong(3, basket.getQuantity());
            statement.setDouble(4, basket.getPrice());
            statement.setLong(5, basket.getId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public int delete(long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM basket WHERE basket_id = ?");) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
/*
    public int delete() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE basket SET orders_id = ?, items_id = ?, quantity = ?, total_cost = ? WHERE basket_id = ?");) {
            statement.setLong(1, basket.getOrderid());
            statement.setLong(2, basket.getItemid());
            statement.setLong(3, basket.getQuantity());
            statement.setDouble(4, basket.getPrice());
            statement.setLong(5, basket.getId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            System.out.println(e);
        } return 0;
    }
*/
}

