
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
	 
	 public static void main(String[] args) throws SQLException {
		 
         // --- Oracle Connection Details (SCOTT Schema) ---
		 // NOTE: Values updated based on your DBeaver configuration.
		 String host = "localhost";
         String port = "1521"; 
         // Service Name is likely named after the user/schema: SCOTT
         String serviceName = "SCOTT"; 
         
         String url = "jdbc:oracle:thin:@//" + host + ":" + port + "/" + serviceName;
         
		 // User confirmed by DBeaver configuration
		 String user = "SCOTT"; 
		 // ACTION REQUIRED: Replace this placeholder with the actual password for the 'SCOTT' user.
         // This is often 'tiger' by default, but depends on your installation.
		 String password = "TIGER"; 
		 
		 try {
             // Step 2: Establish the connection (Driver is found automatically)
			 try(Connection connection = DriverManager.getConnection( url , user , password))
			 {
				 System.out.println("✅ Connection successful to Oracle Database!");
			 }
	     }
		 catch (SQLException e) {
			
			 System.err.println("❌ Connection failed due to a database error.");
             System.err.println("Check TNS listener status, URL format, and the PASSWORD constant in Main.java.");
			 e.printStackTrace();
		 }
         catch (Exception e) {
             System.err.println("❌ An unexpected error occurred.");

			 
             e.printStackTrace();
         }
	 }
}