

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {

    public static void main(String[] args) {

        // Local MongoDB URI
        String uri = "mongodb://localhost:27017/";
        
        // This is typically the simplest way to connect to a local server
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            // To test the connection, we list the database names
            System.out.println("Connection attempt successful.");
            System.out.println("Listing available databases:");

            // Get a list of all database names
            for (String dbName : mongoClient.listDatabaseNames()) {
                System.out.println("- " + dbName);
            }

            // Access a specific database (it will be created if it doesn't exist upon first write)
            MongoDatabase database = mongoClient.getDatabase("myTestDatabase");
            System.out.println("\n✅ Successfully connected and accessed database: " + database.getName());
            
        } catch (Exception e) {
            System.err.println("❌ MongoDB connection failed.");
            System.err.println("Ensure 'mongod' is running on port 27017.");
            e.printStackTrace();
        }
    }
}