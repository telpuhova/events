package models;


public class Rec extends Event{

    private Boolean alcohol;
    private Boolean active;
    private Boolean kidFriendly;
    private int id;

    public Rec(String name, String date, String location, String description, Boolean alcohol, Boolean active, Boolean kidFriendly) {
        super(name, date, location, description);
        this.alcohol = alcohol;
        this.active = active;
        this.kidFriendly = kidFriendly;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Boolean alcohol) {
        this.alcohol = alcohol;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getKidFriendly() {
        return kidFriendly;
    }

    public void setKidFriendly(Boolean kidFriendly) {
        this.kidFriendly = kidFriendly;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rec rec = (Rec) o;

        if (alcohol != null ? !alcohol.equals(rec.alcohol) : rec.alcohol != null) return false;
        if (active != null ? !active.equals(rec.active) : rec.active != null) return false;
        return kidFriendly != null ? kidFriendly.equals(rec.kidFriendly) : rec.kidFriendly == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (alcohol != null ? alcohol.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (kidFriendly != null ? kidFriendly.hashCode() : 0);
        return result;
    }
}
