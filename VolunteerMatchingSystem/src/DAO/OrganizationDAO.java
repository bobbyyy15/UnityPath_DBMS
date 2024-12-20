package dao;

import Database.VolunteerMatchingDB;
import Models.Organization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationDAO {
    public boolean addOrganization(Organization organization) {
        String query = "INSERT INTO Organizations (name, password) VALUES (?, ?)";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, organization.getName());
            stmt.setString(2, organization.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Organization getOrganizationByName(String name) {
        String query = "SELECT * FROM Organizations WHERE name = ?";
        try (Connection conn = VolunteerMatchingDB.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Organization(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}