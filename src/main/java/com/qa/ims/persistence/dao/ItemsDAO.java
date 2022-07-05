package com.qa.ims.persistence.dao;


import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO implements Dao<Items> {


    @Override
    public List<Items> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Items");) {
            List<Items> Items = new ArrayList<>();
            while (resultSet.next()) {
                Items.add(modelFromResultSet(resultSet));
            }
            return Items;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @Override
    public Items read(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");) {
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
    public

    @Override
    public Items create(Items items) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO Items(, ) VALUES (?, ?)");) {
            statement.setString(1, items.getProductName());
            statement.setDouble(2, items.getProductPrice());;
            statement.execute();
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Items update(Items items) {
        return null;
    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
        int productID = resultSet.getInt("");
        String productName = resultSet.getString("");
        double productPrice = resultSet.getDouble("");
        return new Items(productID, productName, productPrice);
    }
}
