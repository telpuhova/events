package dao;


import models.Rec;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;

public class Sql2oRecDaoTest {

    private Sql2oRecDao recDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT= RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        recDao = new Sql2oRecDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() throws Exception {
        Rec rec = new Rec("Bike ride", "01/01/1999", "location", "blah blah blah", false, true, true);
        recDao.add(rec);
        assertEquals(1, rec.getId());
        assertEquals(1, recDao.getAll().size());
    }

    @Test
    public void findById() throws Exception {
        Rec rec = new Rec ("Bike ride", "01/01/1999", "location","blah blah blah", false, true, true);
        recDao.add(rec);
        assertEquals("Bike ride", recDao.findById(1).getName());
    }

    @Test
    public void getAll() throws Exception {
        Rec rec1 = new Rec ("Bike ride", "01/01/1999", "location","blah blah blah", false, true, true);
        Rec rec2 = new Rec ("Bike ride", "01/01/1999", "location","blah blah blah", false, true, true);
        recDao.add(rec1);
        recDao.add(rec2);
        assertEquals(2, recDao.getAll().size());
    }

}
