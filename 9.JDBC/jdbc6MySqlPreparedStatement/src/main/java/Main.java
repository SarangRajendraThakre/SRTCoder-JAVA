import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // --- Database Configuration ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/p1";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String TABLE_NAME = "products";

    // SQL for demonstration
    private static final String SELECT_SQL = "SELECT item_name, price FROM " + TABLE_NAME + " WHERE price > ?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.println("Connection successful.");

            // 1. Ensure the demo table exists and has data (using a simple Statement)
            setupTable(conn);

            // --- DEMO 1: Using executeQuery() (The Standard Way) ---
            System.out.println("\n--- DEMO 1: Using executeQuery() ---");
            getResultSetUsingExecuteQuery(conn, 15.00);

            // --- DEMO 2: Using execute() and getResultSet() ---
            System.out.println("\n--- DEMO 2: Using execute() and getResultSet() ---");
            getResultSetUsingExecute(conn, 5.00);

        } catch (SQLException e) {
            System.err.println("Database error occurred.");
            e.printStackTrace();
        }
    }

    // --- Helper to Setup and Insert Data ---
    private static void setupTable(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("DROP TABLE IF EXISTS " + TABLE_NAME);
            stmt.executeUpdate("CREATE TABLE " + TABLE_NAME + " (id INT PRIMARY KEY AUTO_INCREMENT, item_name VARCHAR(100), price DECIMAL(10, 2))");
            stmt.executeUpdate("INSERT INTO " + TABLE_NAME + " (item_name, price) VALUES ('Book', 10.00), ('Laptop', 500.00), ('Pencil', 1.50)");
            System.out.println("Setup complete: '" + TABLE_NAME + "' ready with sample data.");
        }
    }

    // --- DEMO 1: Using executeQuery() ---
    private static void getResultSetUsingExecuteQuery(Connection conn, double minPrice) throws SQLException {
        // This method is designed specifically for SELECT statements.

        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL)) {

            pstmt.setDouble(1, minPrice);

            // 1. Direct call: executeQuery() returns the ResultSet object
            try (ResultSet rs = pstmt.executeQuery()) {

                System.out.printf("Query executed for items > $%.2f%n", minPrice);
                while (rs.next()) {
                    System.out.println(" - Found: " + rs.getString("item_name"));
                }
            } // ResultSet rs closes here
        }
    } // PreparedStatement pstmt closes here

    // --- DEMO 2: Using execute() and getResultSet() ---
    private static void getResultSetUsingExecute(Connection conn, double minPrice) throws SQLException {
        // execute() is used for commands where the result type is unknown (could be a table or an update count).

        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL)) {

            pstmt.setDouble(1, minPrice);

            // 1. Call execute(): returns TRUE if a ResultSet is available, FALSE otherwise.
            boolean hasResultSet = pstmt.execute();

            if (hasResultSet) {
                // 2. If TRUE, use getResultSet() to retrieve the object
                try (ResultSet rs = pstmt.getResultSet()) {

                    System.out.printf("execute() returned TRUE. Retrieving ResultSet...%n");
                    while (rs.next()) {
                        System.out.println(" - Found: " + rs.getString("item_name"));
                    }
                } // ResultSet rs closes here
            } else {
                // If FALSE, use getUpdateCount() to retrieve the row count (e.g., from an INSERT)
                int updateCount = pstmt.getUpdateCount();
                System.out.printf("execute() returned FALSE. Update count: %d%n", updateCount);
            }
        }
    }
}