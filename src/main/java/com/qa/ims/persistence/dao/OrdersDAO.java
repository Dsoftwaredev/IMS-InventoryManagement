package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO implements Dao<Orders> {
    @Override
    public List<Orders> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            List<Orders> order = new ArrayList<>();
            while (resultSet.next()) {
                order.add(modelFromResultSet(resultSet));
            }
            return order;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public Orders read(Long orderID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
            statement.setLong(1, orderID);
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
    public Orders create(Orders orders) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO Orders(customer_id, cust_id, item_id ) VALUES (?, ?, ?)");) {
            statement.setLong(1, orders.getCustID());
            statement.setLong(2, orders.getItemID());
            statement.setLong(3, orders.getItemID());
            statement.execute();
            return readLatest();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Orders update(Orders orders) {
        return null;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
            long orderID = resultSet.getInt("id");
            long custID = resultSet.getInt("cust_id");
            long ItemID = resultSet.getInt("item_id");
            return new Orders(orderID, custID, ItemID);
        }


    public Orders readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }
}
