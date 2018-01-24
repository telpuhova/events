package dao;


import models.Tech;

import java.util.List;

public interface TechDao {

    //create
    void add(Tech tech);

    //read
    Tech findById(int id);
    List<Tech> getAll();

    //update
    void update(String name, String date, String location, String description, String level, String language, String framework, String job);

    //delete
    void deleteById(int id);
    void clearAll();
}
