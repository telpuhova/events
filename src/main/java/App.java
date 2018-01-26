import com.google.gson.Gson;
import dao.Sql2oEventDao;
import dao.Sql2oRecDao;
import exceptions.ApiException;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oEventDao eventDao;
        Sql2oRecDao recDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/events.db;INIT = RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        eventDao = new Sql2oEventDao(sql2o);
        recDao = new Sql2oRecDao(sql2o);
        conn = sql2o.open();

        //Event

        post("/events/new", "application/json", (req,res) -> {
            Event event = gson.fromJson(req.body(),Event.class);
            res.status(201);
            return gson.toJson(event);
        });


        get("/events", "application/json", (req, res) -> {
            return gson.toJson(eventDao.getAll());
        });

        get("/events/:id", "application/json", (request, response) -> {
            int eventId = Integer.parseInt(request.params("id"));

            Event eventToFind = eventDao.findById(eventId);

            if (eventToFind == null) {
                throw new ApiException(404, String.format("No event with this id: \"%s\" exists ", request.params("id")));
            }
        })



        //Rec




    }


}
