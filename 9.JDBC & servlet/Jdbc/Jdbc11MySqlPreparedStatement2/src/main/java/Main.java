import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // IMPORTANT: Update these details for your specific database (e.g., MySQL)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/p1"; 
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String TABLE_NAME = "products";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. Establish the connection
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful.");

            // --- STEP 1: Manage Table Structure (Setup) ---
            createAndPrepareTable(conn);

            // --- STEP 2: PreparedStatement Demonstration ---
            demoPreparedStatement(conn);

        } catch (SQLException e) {
            System.err.println("\n❌ A critical database error occurred.");
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Drops the table if it exists and recreates it.
     */
    private static void createAndPrepareTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            
            // Safety measure: Drop the table if it exists (ignore error if it doesn't)
            System.out.println("\n--- 1. Table Management ---");
            try {
                stmt.executeUpdate("DROP TABLE " + TABLE_NAME);
                System.out.println("🧹 Existing table 'products' dropped.");
            } catch (SQLException e) {
                // Ignore "table not found" error during the drop attempt
            }
            
            // Create the table with an AUTO_INCREMENT primary key
            String sqlCreate = "CREATE TABLE " + TABLE_NAME + " (" +
                                "id INT PRIMARY KEY AUTO_INCREMENT," +
                                "product_name VARCHAR(255) NOT NULL," +
                                "price DECIMAL(10, 2) NOT NULL" +
                                ")";
            stmt.executeUpdate(sqlCreate);
            System.out.println("✅ Table 'products' created with AUTO_INCREMENT ID.");

        }
    }

    /**
     * Demonstrates PreparedStatement usage and retrieving the generated key.
     */
    private static void demoPreparedStatement(Connection conn) throws SQLException {
        System.out.println("\n--- 2. PreparedStatement Demo ---");
        
        String sql = "INSERT INTO " + TABLE_NAME + " (product_name, price) VALUES (?, ?)";

        // 1. Use the overloaded prepareStatement method to request generated keys
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // 2. Set the parameters (secure against SQL Injection)
            String productName = "Wireless Mouse";
            double productPrice = 25.50;
            
            ps.setString(1, productName);
            ps.setDouble(2, productPrice);
            
            System.out.println("Attempting INSERT for: " + productName + "...");

            // 3. Execute the INSERT
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                // 4. Retrieve the auto-generated key(s)
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1); // Get the value of the first key column (the ID)
                        System.out.println("✅ INSERT successful.");
                        System.out.println("➡️ Retrieved Auto-Generated ID: " + generatedId);
                    }
                }
            } else {
                System.out.println("❌ INSERT failed. No rows affected.");
            }
        }
    }
}