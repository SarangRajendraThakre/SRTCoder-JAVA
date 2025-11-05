

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main{
	 
	 public static void main(String[] args) throws SQLException {
		 
		 String url = "jdbc:postgresql://localhost:5432/SrtDb";
		 String user = "postgres"; 
		 String password = "root"; // Keep this as the password you set during installation
		 
		 try {
          
             
			 try(Connection connection = DriverManager.getConnection( url , user , password))
			 {
				 System.out.println(" postgre Connection successful");
			 }
	     }
		 catch (Exception e) {
			
			 // Use System.err for error output, and include the actual exception type
             System.err.println("Connection failed due to an error.");
			 e.printStackTrace();
		 }
	 }
}
