package Main;

import java.util.*;

public class Main {
    static List<Volunteer> volunteers = new ArrayList<>();
    static List<Organization> organizations = new ArrayList<>();
    static List<Opportunity> opportunities = new ArrayList<>();
    static List<Application> applications = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeScreen();
    }

    public static void displayWelcomeScreen() {
        System.out.println("========================================================================");
        System.out.println("|                 WELCOME TO VOLUNTEER MATCHING SYSTEM                 |");
        System.out.println("========================================================================");
        System.out.println("| 1. Register as Volunteer                                             |");
        System.out.println("| 2. Register as Organization                                          |");
        System.out.println("| 3. Login as Volunteer                                                |");
        System.out.println("| 4. Login as Organization                                             |");
        System.out.println("| 5. Exit                                                              |");
        System.out.println("========================================================================");
        System.out.print("Choose an option: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerVolunteer();
                case 2 -> registerOrganization();
                case 3 -> loginAsVolunteer();
                case 4 -> loginAsOrganization();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid option. Try again.");
            }
            displayWelcomeScreen();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            displayWelcomeScreen();
        }
    }

    public static void registerVolunteer() {
        System.out.println("========================================================================");
        System.out.println("|                     REGISTER AS VOLUNTEER                            |");
        System.out.println("========================================================================");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter skills (comma-separated): ");
        String skills = scanner.nextLine();

        int id = volunteers.size() + 1;
        volunteers.add(new Volunteer(id, name, password, skills));
        System.out.println("Volunteer registered successfully! Your ID is: " + id);
    }

    public static void registerOrganization() {
        System.out.println("========================================================================");
        System.out.println("|                   REGISTER AS ORGANIZATION                           |");
        System.out.println("========================================================================");
        System.out.print("Enter organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        int id = organizations.size() + 1;
        organizations.add(new Organization(id, name, password));
        System.out.println("Organization registered successfully! Your ID is: " + id);
    }

    public static void loginAsVolunteer() {
        System.out.println("========================================================================");
        System.out.println("|                      LOGIN AS VOLUNTEER                              |");
        System.out.println("========================================================================");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Volunteer volunteer : volunteers) {
            if (volunteer.getName().equals(name) && volunteer.getPassword().equals(password)) {
                volunteerDashboard(volunteer);
                return;
            }
        }
        System.out.println("Invalid credentials. Try again.");
    }

    public static void loginAsOrganization() {
        System.out.println("========================================================================");
        System.out.println("|                   LOGIN AS ORGANIZATION                              |");
        System.out.println("========================================================================");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (Organization org : organizations) {
            if (org.getName().equals(name) && org.getPassword().equals(password)) {
                organizationDashboard(org);
                return;
            }
        }
        System.out.println("Invalid credentials. Try again.");
    }

    public static void volunteerDashboard(Volunteer volunteer) {
        System.out.println("========================================================================");
        System.out
                .println("|                    WELCOME " + volunteer.getName().toUpperCase() + "                    |");
        System.out.println("========================================================================");
        System.out.println("| 1. View Opportunities                                                |");
        System.out.println("| 2. Apply for Opportunities                                           |");
        System.out.println("| 3. View My Schedule                                                  |");
        System.out.println("| 4. Log Out                                                           |");
        System.out.println("========================================================================");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> viewOpportunities();
            case 2 -> applyForOpportunity(volunteer);
            case 3 -> viewSchedule(volunteer);
            case 4 -> displayWelcomeScreen();
            default -> System.out.println("Invalid option. Try again.");
        }
        volunteerDashboard(volunteer);
    }

    public static void organizationDashboard(Organization org) {
        System.out.println("========================================================================");
        System.out
                .println("|                   WELCOME " + org.getName().toUpperCase() + "                          |");
        System.out.println("========================================================================");
        System.out.println("| 1. View Opportunities                                                |");
        System.out.println("| 2. Post Opportunity                                                  |");
        System.out.println("| 3. View Applicants                                                   |");
        System.out.println("| 4. Accept/Reject Applicants                                          |");
        System.out.println("| 5. Log Out                                                           |");
        System.out.println("========================================================================");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> viewOpportunitiesByOrg(org);
            case 2 -> postOpportunity(org);
            case 3 -> viewApplicants(org);
            case 4 -> manageApplications(org);
            case 5 -> displayWelcomeScreen();
            default -> System.out.println("Invalid option. Try again.");
        }
        organizationDashboard(org);
    }

    public static void viewOpportunities() {
        System.out.println("========================================================================");
        System.out.println("|                            ALL OPPORTUNITIES                         |");
        System.out.println("========================================================================");
        System.out.printf("| %-5s | %-20s | %-10s | %-10s | %-10s |\n", "ID", "Title", "Skills", "Start Date",
                "End Date");
        System.out.println("========================================================================");
        for (Opportunity opp : opportunities) {
            System.out.printf("| %-5d | %-20s | %-10s | %-10s | %-10s |\n",
                    opp.getId(), opp.getTitle(), opp.getRequiredSkills(),
                    opp.getStartDate(), opp.getEndDate());
        }
        System.out.println("========================================================================");
    }

    public static void applyForOpportunity(Volunteer volunteer) {
        viewOpportunities();
        System.out.print("Enter the ID of the opportunity to apply for: ");
        int oppId = scanner.nextInt();
        scanner.nextLine();

        Opportunity opp = opportunities.stream()
                .filter(o -> o.getId() == oppId)
                .findFirst()
                .orElse(null);

        if (opp == null) {
            System.out.println("Invalid Opportunity ID.");
            return;
        }

        applications.add(new Application(volunteer, opp));
        System.out.println("Application submitted successfully!");
    }

    public static void viewSchedule(Volunteer volunteer) {
        System.out.println("========================================================================");
        System.out.println("|                          MY SCHEDULE                                 |");
        System.out.println("========================================================================");
        System.out.printf("| %-20s | %-10s | %-10s |\n", "Title", "Start Date", "End Date");
        System.out.println("========================================================================");
        for (Application app : applications) {
            if (app.getVolunteer().equals(volunteer) && "Accepted".equals(app.getStatus())) {
                Opportunity opp = app.getOpportunity();
                System.out.printf("| %-20s | %-10s | %-10s |\n", opp.getTitle(), opp.getStartDate(), opp.getEndDate());
            }
        }
        System.out.println("========================================================================");
    }

    public static void viewOpportunitiesByOrg(Organization org) {
        System.out.println("========================================================================");
        System.out.println(
                "|                OPPORTUNITIES POSTED BY " + org.getName().toUpperCase() + "               |");
        System.out.println("========================================================================");
        for (Opportunity opp : opportunities) {
            if (opp.getPostedBy().equals(org)) {
                System.out.printf("| %-5d | %-20s |\n", opp.getId(), opp.getTitle());
            }
        }
        System.out.println("========================================================================");
    }

    public static void postOpportunity(Organization org) {
        System.out.print("Enter opportunity title: ");
        String title = scanner.nextLine();
        System.out.print("Enter required skills: ");
        String skills = scanner.nextLine();
        System.out.print("Enter start date (yyyy-mm-dd): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter end date (yyyy-mm-dd): ");
        String endDate = scanner.nextLine();

        opportunities.add(new Opportunity(opportunities.size() + 1, title, skills, org, startDate, endDate));
        System.out.println("Opportunity posted successfully!");
    }

    public static void viewApplicants(Organization org) {
        System.out.println("========================================================================");
        System.out.println("|                      APPLICANTS FOR OPPORTUNITIES                    |");
        System.out.println("========================================================================");
        for (Application app : applications) {
            Opportunity opp = app.getOpportunity();
            if (opp.getPostedBy().equals(org)) {
                System.out.printf("| %-5d | %-20s | %-10s |\n", app.getVolunteer().getId(),
                        app.getVolunteer().getName(), app.getStatus());
            }
        }
        System.out.println("========================================================================");
    }

    public static void manageApplications(Organization org) {
        System.out.print("Enter opportunity ID to manage applicants: ");
        int oppId = scanner.nextInt();
        scanner.nextLine();

        Opportunity opp = opportunities.stream()
                .filter(o -> o.getId() == oppId)
                .findFirst()
                .orElse(null);

        if (opp == null) {
            System.out.println("Invalid Opportunity ID.");
            return;
        }

        System.out.println("Managing applicants for opportunity: " + opp.getTitle());
        for (Application app : applications) {
            if (app.getOpportunity().equals(opp)) {
                System.out.println("Volunteer: " + app.getVolunteer().getName());
                System.out.print("Enter status for this volunteer (Accepted/Rejected): ");
                String status = scanner.nextLine();
                app.setStatus(status);
            }
        }
    }
}
