import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {

    // --- Database Configuration (MySQL) ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/p1";
    private static final String USER = "root";
    private static final String PASS = "root";

    // --- Static SQL Commands ---
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS inventory (id INT PRIMARY KEY AUTO_INCREMENT, item_name VARCHAR(100), price DECIMAL(10, 2))";
    private static final String INSERT_SQL = "INSERT INTO inventory (item_name, price) VALUES ('Widget A', 10.50)";
    private static final String SELECT_SQL = "SELECT item_name, price FROM inventory WHERE price > 10.00";
    private static final String DELETE_SQL = "DELETE FROM inventory WHERE item_name = 'Widget A'";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) // Statement object created once
        {
            System.out.println("Connection successful.");

            // --- 1. executeUpdate(String sql) for DDL/DML ---
            System.out.println("\n--- 1. executeUpdate (INSERT/DELETE/DDL) ---");
            // Used for commands that change data or structure (returns rows affected or 0)

            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Created table 'inventory' (if it didn't exist).");

            int rowsAffected = stmt.executeUpdate(INSERT_SQL);
            System.out.println("INSERT command executed. Rows affected: " + rowsAffected);

            // --- 2. executeQuery(String sql) for SELECT ---
            System.out.println("\n--- 2. executeQuery (SELECT) ---");
            // Used specifically for SELECT commands (returns a ResultSet)
            try (ResultSet rs = stmt.executeQuery(SELECT_SQL)) {

                System.out.println("Query executed. Results:");
                while (rs.next()) {
                    System.out.println(" - Item: " + rs.getString("item_name") + ", Price: $" + rs.getDouble("price"));
                }
            } // ResultSet is automatically closed here

            // --- 3. Batch Processing Methods ---
            System.out.println("\n--- 3. Batch Processing (addBatch / executeBatch) ---");
            conn.setAutoCommit(false); // Enable manual transaction control for batching

            // a. addBatch(String sql)
            stmt.addBatch("INSERT INTO inventory (item_name, price) VALUES ('Batch Item 1', 5.00)");
            stmt.addBatch("UPDATE inventory SET price = 15.00 WHERE item_name = 'Widget A'");
            stmt.addBatch("INSERT INTO inventory (item_name, price) VALUES ('Batch Item 2', 7.50)");
            System.out.println("Added 3 commands to the batch.");

            // b. executeBatch()
            int[] updateCounts = stmt.executeBatch();
            System.out.println("Batch executed. Counts:");
            for (int count : updateCounts) {
                System.out.println(" - Command affected " + count + " row(s).");
            }

            conn.commit(); // Make the batch changes permanent
            System.out.println("Batch committed successfully.");

            // c. clearBatch() - not explicitly needed, but important to know
            stmt.clearBatch();

            // --- 4. execute(String sql) for Unknown Type ---
            System.out.println("\n--- 4. execute (Versatile) ---");
            // Used when you don't know if the SQL is a SELECT or an UPDATE/DELETE

            boolean hasResultSet = stmt.execute(DELETE_SQL);

            if (hasResultSet) {
                System.out.println("Error: Expected an update count, but got a ResultSet.");
            } else {
                int count = stmt.getUpdateCount(); // Use getUpdateCount() if execute() returns false
                System.out.println("DELETE command executed via execute(). Rows affected: " + count);
            }

        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}