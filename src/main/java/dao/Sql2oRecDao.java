package dao;


import models.Rec;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oRecDao implements RecDao{

    Sql2o sql2o;

    public Sql2oRecDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void add(Rec rec) {
        String sql = "INSERT INTO rec (name, date, location, description, alcohol, active, kidFriendly) VALUES (:name, :date, :location, :description, :alcohol, :active, :kidFriendly)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(rec)
                    .executeUpdate()
                    .getKey();
            rec.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public Rec findById(int id) {
        String sql = "SELECT * FROM rec WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Rec.class);
        }
    }

    public List<Rec> getAll() {
        String sql = "SELECT * FROM rec";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Rec.class);
        }
    }

    public void update(int id, String name, String date, String location, String description, Boolean alcohol, Boolean active, Boolean kidFriendly){
        String sql = "UPDATE rec SET name = :name, date = :date, location = :location, description = :description, alcohol = :alcohol, active = :active, kidFriendly = :kidFriendly WHERE id = :id";
        try(Connection con = sql2o.open()) {
             con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("date", date)
                    .addParameter("location", location)
                    .addParameter("description", description)
                    .addParameter("alcohol", alcohol)
                    .addParameter("active", active)
                    .addParameter("kidFriendly", kidFriendly)
                    .executeUpdate();
        }
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM rec WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    public void clearAll() {
        String sql = "DELETE FROM rec";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
