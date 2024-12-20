package Main;

public class Volunteer {
    private int id;
    private String name;
    private String password;
    private String skills;

    // Constructor for creating a volunteer without an ID (for Create)
    public Volunteer(String name, String password, String skills) {
        this.name = name;
        this.password = password;
        this.skills = skills;
    }

    // Constructor for reading an existing volunteer from the database (for Read)
    public Volunteer(int id, String name, String password, String skills) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.skills = skills;
    }

    // Getters and setters for the fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
