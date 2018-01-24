package models;


public class Event {

    private String name;
    private String date;
    private String location;
    private String description;
    private int id;

    public Event(String name) {
        this.name = name;
    }

    public Event(String name, String date, String location, String description) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != event.id) return false;
        if (!name.equals(event.name)) return false;
        if (date != null ? !date.equals(event.date) : event.date != null) return false;
        if (location != null ? !location.equals(event.location) : event.location != null) return false;
        return description != null ? description.equals(event.description) : event.description == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
