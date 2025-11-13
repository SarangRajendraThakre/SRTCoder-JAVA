import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/p1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            System.out.println("✅ Connection established successfully.");

            // Check if connection is valid (wait up to 5 seconds)
            boolean valid = con.isValid(5);

            if (valid) {
                System.out.println("✅ Connection is valid and active.");
            } else {
                System.out.println("❌ Connection is NOT valid or unreachable.");
            }

            // Close the connection
            con.close();

            // Check again after closing
            boolean validAfterClose = con.isValid(2);
            System.out.println("After closing, is connection valid? " + validAfterClose);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}