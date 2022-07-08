package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Orders;

import com.qa.ims.utils.DBUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDAOTest {
    private final OrdersDAO test = new OrdersDAO();

    @Before
    public void setup() {
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate() {
        final Orders created = new Orders(2L, 1, 1);
        assertEquals(created, test.create(created));
    }


    @Test
    public void testReadAll() {
        List<Orders> expected = new ArrayList<>();
        expected.add(new Orders(1L, 1, 1));
        assertEquals(expected, test.readAll());
    }

    @Test
    public void testReadLatest() {
        assertEquals(new Orders(1L, 1, 1), test.readLatest());
    }

    @Test
    public void testRead() {
        final long id = 1L;
        assertEquals(new Orders(1L, 1, 1), test.read(id));
    }

    @Test
    public void testUpdate() {
        final Orders testUpdate = new Orders(1L, 2, 2);
        assertEquals(testUpdate, test.update(testUpdate));
    }

    @Test
    public void testDelete() {
        assertEquals(1, test.delete(1));
    }

}



