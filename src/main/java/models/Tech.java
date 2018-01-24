package models;


public class Tech extends Event {

    private String level;
    private String language;
    private String framework;
    private String job;
    private int id;

    public Tech(String name, String date, String location, String description, String level, String language, String framework, String job) {
        super(name, date, location, description);
        this.level = level;
        this.language = language;
        this.framework = framework;
        this.job = job;

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

        Tech tech = (Tech) o;

        if (id != tech.id) return false;
        if (level != null ? !level.equals(tech.level) : tech.level != null) return false;
        if (language != null ? !language.equals(tech.language) : tech.language != null) return false;
        if (framework != null ? !framework.equals(tech.framework) : tech.framework != null) return false;
        return job != null ? job.equals(tech.job) : tech.job == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (framework != null ? framework.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
