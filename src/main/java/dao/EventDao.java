package dao;

import models.Event;

import java.util.List;

public interface EventDao {

    //create
    void add(Event event);

    //read
    List<Event> getAll();

    Event findById(int id);

    //update
    void update(int id, String name, String date, String location, String description);


    //delete
    void deleteById(int id);
    void clearAll();



}
