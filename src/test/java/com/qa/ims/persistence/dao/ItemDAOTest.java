package com.qa.ims.persistence.dao;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemDAOTest {


    private final ItemDAO test = new ItemDAO();

    @Before
    public void setup() {
        DBUtils.connect();
        DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
    }

    @Test
    public void testCreate() {
        final Item created = new Item(2L, "guitar", 200);
        assertEquals(created, test.create(created));
    }
    @Test
    public void testReadAll() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, "test", 100));
        assertEquals(expected, test.readAll());
    }
    @Test
    public void testReadLatest() {
        assertEquals(new Item(1L, "test", 100), test.readLatest());
    }
    @Test
    public void testRead() {
        final long id = 1L;
        assertEquals(new Item(1L, "test", 100), test.read(id));
    }
    @Test
    public void testUpdate() {
        final Item testUpdate = new Item(1L, "Daniel", 1000);
        assertEquals(testUpdate, test.update(testUpdate));
    }
    @Test
    public void testDelete() {
        assertEquals(1, test.delete(1));
    }
}
