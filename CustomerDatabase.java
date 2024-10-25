package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDatabase {
	
	private static final String url = "jdbc:mysql://localhost:3306/student";
    private static final String username = "root";
    private static final String password = "9179260781@";

    public static void main(String[] args) {
        // Sample customer data
        String name = "Rajesh";
        String email = "rajesh@example.com";
        String phone = "1234567890";

        // Call the insert method
        insertCustomer(name, email, phone);
    }

    // Method to insert customer data
    public static void insertCustomer(String name, String email, String phone) {
        // SQL query to insert data
        String sql = "INSERT INTO customer (name, email, phone) VALUES (?, ?, ?)";

        // Establish connection and execute query
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the prepared statement
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);

            // Execute the insert
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Inserted " + rowsAffected + " row(s) into the customer table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




