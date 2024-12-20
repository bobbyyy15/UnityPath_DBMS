package lib;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {
        try {
            // Attempt to establish a connection
            Connection connection = DatabaseConnection.getConnection();

            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to establish connection.");
            }

        } catch (SQLException e) {
            // Handle the exception if something goes wrong
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // Handle other exceptions
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
