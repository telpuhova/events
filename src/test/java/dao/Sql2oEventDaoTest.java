package dao;

import models.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oEventDaoTest {


    private Sql2oEventDao eventDao;
    private Connection conn;

    Event setUpEvent = new Event ("Criptocurrency 101", "01/01/1999", "1234 Some street, Portland, OR", "blah blah blah");

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o (connectionString, "", "");
        eventDao = new Sql2oEventDao(sql2o);
        conn = sql2o.open();


    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add() throws Exception {
        Event event = new Event("Criptocurrency 101", "01/01/1999", "1234 Some street, Portland, OR", "blah blah blah");
        eventDao.add(event);
        assertEquals(1, event.getId());
        assertEquals(1, eventDao.getAll().size());
    }

    @Test
    public void getAll() throws Exception {
        Event event = setUpEvent;
        Event eventTwo = setUpEvent;
        Event notAddedEvent = setUpEvent;
        eventDao.add(event);
        eventDao.add(eventTwo);
        assertEquals(2, eventDao.getAll().size());
    }

    @Test
    public void update() throws Exception {
        Event event1 = setUpEvent;
        Event event2 = setUpEvent;
        eventDao.add(event1);
        eventDao.add(event2);
        eventDao.update(event2.getId(), "newname", "", "", "");
        assertEquals("newname", eventDao.findById(event2.getId()).getName());
    }

    @Test
    public void findById() throws Exception {
        Event event = setUpEvent;
        Event eventTwo = setUpEvent;
        eventDao.add(event);
        eventDao.add(eventTwo);
        assertEquals("Criptocurrency 101", eventDao.findById(1).getName());

    }

    @Test
    public void deleteById() throws Exception {
        Event event = setUpEvent;
        Event event1 = setUpEvent;
        eventDao.add(event);
        eventDao.add(event1);
        eventDao.deleteById(1);
        assertEquals(1, eventDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Event event = setUpEvent;
        Event eventTwo = setUpEvent;
        eventDao.add(event);
        eventDao.add(eventTwo);
        eventDao.clearAll();
        assertEquals(0, eventDao.getAll().size());
    }

}