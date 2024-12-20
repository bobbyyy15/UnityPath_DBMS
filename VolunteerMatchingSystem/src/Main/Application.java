package Main;

public class Application {
    private Volunteer volunteer;
    private Opportunity opportunity;
    private String status;

    public Application(Volunteer volunteer, Opportunity opportunity) {
        this.volunteer = volunteer;
        this.opportunity = opportunity;
        this.status = "Pending"; // Default status
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
