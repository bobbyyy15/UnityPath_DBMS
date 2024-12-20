package Main;

public class Opportunity {
    private int id;
    private String title;
    private String requiredSkills;
    private Organization postedBy;
    private String startDate;
    private String endDate;

    public Opportunity(int id, String title, String requiredSkills, Organization postedBy, String startDate,
            String endDate) {
        this.id = id;
        this.title = title;
        this.requiredSkills = requiredSkills;
        this.postedBy = postedBy;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public Organization getPostedBy() {
        return postedBy;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
