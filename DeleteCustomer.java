package com.jdbcdemo;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteCustomer {
	
	// Database URL, username, and password
    private static final String url = "jdbc:mysql://localhost:3306/student";
    private static final String username = "root";
    private static final String password = "9179260781@";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer ID to delete
        System.out.print("Enter Customer ID to delete: ");
        int customerId = scanner.nextInt();

        // Call the delete method
        deleteCustomer(customerId);
    }

    // Method to delete customer data
    public static void deleteCustomer(int customerId) {
        // SQL query to delete data
        String sql = "DELETE FROM customer WHERE id = ?";

        // Establish connection and execute delete query
        try (Connection conn = DriverManager.getConnection(url,username,password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the ID for the prepared statement
            pstmt.setInt(1, customerId);

            // Execute the delete
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deleted " + rowsAffected + " record(s) from the customer table.");
            } else {
                System.out.println("No record found with ID " + customerId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



