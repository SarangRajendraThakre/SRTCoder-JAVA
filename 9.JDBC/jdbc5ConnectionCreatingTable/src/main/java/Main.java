import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // IMPORTANT: Update these details for your specific database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/p1"; // Ensure 'p1' is your correct database name
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Establish the connection
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            stmt = conn.createStatement();
            
            // 2. Define the CREATE TABLE SQL statement
            String sqlCreate = "CREATE TABLE accounts (" +
                                "account_id INT PRIMARY KEY," +
                                "customer_name VARCHAR(100) NOT NULL," +
                                "balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00" +
                                ")";

            // 3. Execute the statement
            stmt.executeUpdate(sqlCreate);
            
            System.out.println("✅ Table 'accounts' created successfully in the database.");

            // 4. Insert an initial record so your AutoCommit program has data to work with
            String sqlInsert = "INSERT INTO accounts (account_id, customer_name, balance) VALUES (101, 'Alice', 500.00)";
            stmt.executeUpdate(sqlInsert);
            System.out.println("✅ Initial data (Account 101) inserted successfully.");

        } catch (SQLException e) {
            // Handle errors for JDBC
            System.err.println("❌ Database Error: Could not create table or insert initial data.");
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            
            // Note: If the table already exists, it will throw an exception.
            // You can ignore or handle error code 1050 (Table already exists).
            
        } finally {
            // 5. Clean up resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}