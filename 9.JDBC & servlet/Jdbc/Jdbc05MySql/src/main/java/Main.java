import java.sql.*;

public class Main {

    public static void main(String[] args) {

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/p1";
        String user = "root";
        String password = "root";

        Connection con = null;

        try {
            // 1️⃣ Load and register driver (optional for JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully");

            // 2️⃣ Establish connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection established!");

            // 3️⃣ Check if connection is open
            System.out.println("Is connection closed? " + con.isClosed());

            // 4️⃣ Get auto-commit status
            System.out.println("AutoCommit: " + con.getAutoCommit());

            // 5️⃣ Disable auto-commit for transaction management
            con.setAutoCommit(false);
            System.out.println("AutoCommit after change: " + con.getAutoCommit());

            // 6️⃣ Set read-only mode
            con.setReadOnly(false);

            // 7️⃣ Create Statement
            Statement st = con.createStatement();
            System.out.println("✅ Statement created!");

            // 8️⃣ Create PreparedStatement
            String insertQuery = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, 101);
            ps.setString(2, "Sarang");
            int rows = ps.executeUpdate();
            System.out.println("Rows inserted: " + rows);

            // 9️⃣ Savepoint example
            Savepoint save1 = con.setSavepoint("InsertDone");
            System.out.println("✅ Savepoint created");

            // 10️⃣ Create CallableStatement for stored procedure
            // Example procedure: CREATE PROCEDURE getStudent(IN id INT)
            // CallableStatement cs = con.prepareCall("{call getStudent(?)}");
            // cs.setInt(1, 101);
            // cs.execute();

            // 11️⃣ Commit transaction
            con.commit();
            System.out.println("✅ Transaction committed successfully!");

            // 12️⃣ Get database metadata
            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("Database: " + dbmd.getDatabaseProductName());
            System.out.println("Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver: " + dbmd.getDriverName());
            System.out.println("User: " + dbmd.getUserName());
            System.out.println("--------------------------\n");

            // 13️⃣ Rollback example (if needed)
            // con.rollback(save1);
            // System.out.println("Rolled back to Savepoint!");

            // 14️⃣ Transaction isolation level
            int isolation = con.getTransactionIsolation();
            System.out.println("Current Isolation Level: " + isolation);

            // 15️⃣ Warnings example
            SQLWarning warning = con.getWarnings();
            if (warning == null) {
                System.out.println("No SQL Warnings");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("🔁 Rolled back transaction due to error.");
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("🔒 Connection closed successfully.");
                }
            } catch (SQLException e) {
                System.out.println("❌ Error closing connection: " + e.getMessage());
            }
        }
    }
}