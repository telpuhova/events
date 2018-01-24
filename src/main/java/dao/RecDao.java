package dao;

import models.*;

import java.util.List;

public interface RecDao {

    //create
    void add(Rec rec);

    //read
    Rec findById(int id);
    List<Rec> getAll();

    //update
    void update(String name, String date, String location, String description, Boolean alcohol, Boolean active, Boolean kidFriendly);

    //delete
    void deleteById(int id);
    void clearAll();
}
