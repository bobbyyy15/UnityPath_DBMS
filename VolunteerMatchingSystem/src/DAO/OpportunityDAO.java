package dao;

import Database.VolunteerMatchingDB;
import Models.Opportunity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDAO {

    public boolean addOpportunity(Opportunity opportunity) {
        String query = "INSERT INTO Opportunities (title, required_skills, posted_by, applicants, start_date, end_date, location) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, opportunity.getTitle());
            stmt.setString(2, opportunity.getRequiredSkills());
            stmt.setString(3, opportunity.getPostedBy());
            stmt.setString(4, opportunity.getApplicants());
            stmt.setDate(5, Date.valueOf(opportunity.getStartDate()));
            stmt.setDate(6, Date.valueOf(opportunity.getEndDate()));
            stmt.setString(7, opportunity.getLocation());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Opportunity> getAllOpportunities() {
        String query = "SELECT * FROM Opportunities";
        List<Opportunity> opportunities = new ArrayList<>();

        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Opportunity opportunity = new Opportunity(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("required_skills"),
                        rs.getString("posted_by"),
                        rs.getString("applicants"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate("end_date").toLocalDate(),
                        rs.getString("location"));
                opportunities.add(opportunity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opportunities;
    }
}
