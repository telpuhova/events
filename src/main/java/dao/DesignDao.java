package dao;

import models.*;

import java.util.List;


public interface DesignDao {

    //create
    void add(Design design);

    //read
    Design findById(int id);
    List<Design> getAll();

    //update
    void update(String name, String date, String location, String description, String speciality);

    //delete
    void deleteById(int id);
    void clearAll();
}
