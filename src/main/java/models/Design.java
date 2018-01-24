package models;


public class Design extends Event {

    private String specialty;
    private int id;

    public Design(String name, String date, String location, String description, String specialty) {
        super(name, date, location, description);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

        Design design = (Design) o;

        if (id != design.id) return false;
        return specialty != null ? specialty.equals(design.specialty) : design.specialty == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (specialty != null ? specialty.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
