import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    

    // --- Configuration (Adjust for your environment) ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/p1";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String TABLE_NAME = "products";

    // --- SQL Templates using '?' Placeholder ---
    private static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE " + TABLE_NAME +
                    " (id INT PRIMARY KEY AUTO_INCREMENT, item_name VARCHAR(100), price DECIMAL(10, 2))";

    private static final String CREATE_SQL =
            "INSERT INTO " + TABLE_NAME + " (item_name, price) VALUES (?, ?)"; // C (Create)

    private static final String READ_SQL =
            "SELECT id, item_name, price FROM " + TABLE_NAME + " WHERE price > ?"; // R (Read)

    private static final String UPDATE_SQL =
            "UPDATE " + TABLE_NAME + " SET price = ? WHERE item_name = ?"; // U (Update)

    private static final String DELETE_SQL =
            "DELETE FROM " + TABLE_NAME + " WHERE id = ?"; // D (Delete)


    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.println("Connection successful. Running CRUD Demo.");

            setupDatabase(conn); // Ensure table is clean and ready

            // --- 1. CREATE (Insert) ---
            int widgetId = createProduct(conn, "Widget X", 9.99);
            createProduct(conn, "Gadget Y", 24.50);

            // --- 2. READ (Select) ---
            readProducts(conn, 15.00);

            // --- 3. UPDATE ---
            updateProductPrice(conn, "Widget X", 12.00);

            // --- 4. READ (Verify Update) ---
            System.out.println("\n--- Products after Update ---");
            readProducts(conn, 10.00);

            // --- 5. DELETE ---
            deleteProduct(conn, widgetId);

            // --- 6. READ (Verify Delete) ---
            System.out.println("\n--- Products after Deletion ---");
            readProducts(conn, 0.00);

        } catch (SQLException e) {
            System.err.println("\n!! FATAL DATABASE ERROR !!");
            e.printStackTrace();
        }
    }

    // --- SETUP: DROP and CREATE Table ---
    private static void setupDatabase(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(DROP_TABLE_SQL);
            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Setup: Table '" + TABLE_NAME + "' initialized.");
        }
    }

    // --- C: CREATE (INSERT) ---
    private static int createProduct(Connection conn, String name, double price) throws SQLException {
        int generatedKey = -1;
        // Request auto-generated keys to be available
        try (PreparedStatement pstmt = conn.prepareStatement(CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, price);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                // Retrieve the auto-generated ID (if supported by DB)
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedKey = rs.getInt(1);
                    }
                }
                System.out.printf("C: Created item '%s' with ID %d.%n", name, generatedKey);
            }
        }
        return generatedKey;
    }

    // --- R: READ (SELECT) ---
    private static void readProducts(Connection conn, double minPrice) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(READ_SQL)) {

            // Set the dynamic parameter
            pstmt.setDouble(1, minPrice);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.printf("R: Found items priced above $%.2f:%n", minPrice);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("item_name");
                    double price = rs.getDouble("price");
                    System.out.printf("   - ID: %d | Name: %s | Price: $%.2f%n", id, name, price);
                }
            }
        }
    }

    // --- U: UPDATE ---
    private static void updateProductPrice(Connection conn, String name, double newPrice) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {

            // Set parameters: 1st '?' is price, 2nd '?' is name
            pstmt.setDouble(1, newPrice);
            pstmt.setString(2, name);

            int rows = pstmt.executeUpdate();
            System.out.printf("\nU: Updated item '%s'. Rows affected: %d.%n", name, rows);
        }
    }

    // --- D: DELETE ---
    private static void deleteProduct(Connection conn, int id) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {

            // Set parameter: 1st '?' is the ID
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            System.out.printf("D: Deleted item with ID %d. Rows affected: %d.%n", id, rows);
        }
    }
}