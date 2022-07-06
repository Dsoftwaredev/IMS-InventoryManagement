package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrdersDAO implements Dao<Orders>{
    @Override
    public List<Orders> readAll() {
        return null;
    }

    @Override
    public Orders read(Long id) {
        return null;
    }

    @Override
    public Orders create(Orders orders) {
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
        return null;
    }
}
