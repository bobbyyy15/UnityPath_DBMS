package dao;

import Database.VolunteerMatchingDB;
import Models.Volunteer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VolunteerDAO {
    public boolean addVolunteer(Volunteer volunteer) {
        String query = "INSERT INTO Volunteers (name, skills, password) VALUES (?, ?, ?)";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, volunteer.getName());
            stmt.setString(2, volunteer.getSkills());
            stmt.setString(3, volunteer.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Volunteer getVolunteerByName(String name) {
        String query = "SELECT * FROM Volunteers WHERE name = ?";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Volunteer(rs.getInt("id"), rs.getString("name"), rs.getString("skills"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}