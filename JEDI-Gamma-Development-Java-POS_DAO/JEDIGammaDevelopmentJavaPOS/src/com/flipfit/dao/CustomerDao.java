package com.flipfit.dao;

import java.sql.*;

public class CustomerDao {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Flipfit_schema";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASS = "rootuser"; // Replace with your MySQL password

    // Method to get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // --- C: Create (Insert) ---
    public void insertCustomer(int id, String name, String email, String contact) {
        // Fixed: Added a 4th '?' to match the 4 columns
        String sql = "INSERT INTO Customer (Id, name, email, contact) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Fixed: Use setInt for the ID field
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, contact);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " customer inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- R: Read (Select) ---
    public void selectAllCustomers() {
        String sql = "SELECT * FROM Customer";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) { //

            System.out.println("--- Customer Records ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                System.out.printf("ID: %d, Name: %s, Email: %s, Contact: %s%n", id, name, email, contact);
            }
            System.out.println("------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- U: Update ---
    public void updateCustomerContact(int id, String newContact) {
        String sql = "UPDATE Customer SET contact = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) { //
            pstmt.setString(1, newContact);
            pstmt.setInt(2, id);

            int rowsAffected = pstmt.executeUpdate(); //
            System.out.println(rowsAffected + " customer contact updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // --- D: Delete ---
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate(); //
            System.out.println(rowsAffected + " customer deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
