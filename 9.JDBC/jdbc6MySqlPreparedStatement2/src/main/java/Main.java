import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/p1";
        String user = "root";
        String password = "root";

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            System.out.println("✅ Connection established.");

            // 1️⃣ Create Table (DDL) - using executeUpdate()
            String createSQL = "CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name VARCHAR(50), marks INT)";
            try (PreparedStatement ps = con.prepareStatement(createSQL)) {
                ps.executeUpdate();
                System.out.println("✅ Table created or already exists.");
            }

            // 2️⃣ Insert Records - using executeUpdate() and setXXX()
            String insertSQL = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
                ps.setInt(1, 1);
                ps.setString(2, "Amit");
                ps.setInt(3, 85);
                ps.executeUpdate();
                System.out.println("✅ Record inserted.");
            }

            // 3️⃣ Select Records - using executeQuery()
            String selectSQL = "SELECT * FROM student";
            try (PreparedStatement ps = con.prepareStatement(selectSQL)) {
                ResultSet rs = ps.executeQuery();
                System.out.println("🎯 Student Records:");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("marks"));
                }
            }

            // 4️⃣ Update Record - using executeUpdate()
            String updateSQL = "UPDATE student SET marks = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(updateSQL)) {
                ps.setInt(1, 90);
                ps.setInt(2, 1);
                int count = ps.executeUpdate();
                System.out.println("✅ Rows updated: " + count);
            }

            // 5️⃣ Batch Insert - using addBatch() and executeBatch()
            String batchSQL = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(batchSQL)) {
                ps.setInt(1, 2);
                ps.setString(2, "Riya");
                ps.setInt(3, 92);
                ps.addBatch();

                ps.setInt(1, 3);
                ps.setString(2, "Suresh");
                ps.setInt(3, 75);
                ps.addBatch();

                int[] results = ps.executeBatch();
                System.out.println("✅ Batch executed, rows affected: " + results.length);
            }

            // 6️⃣ Metadata Example - getMetaData() and getParameterMetaData()
            String metaSQL = "SELECT * FROM student";
            try (PreparedStatement ps = con.prepareStatement(metaSQL)) {
                ResultSetMetaData rsmd = ps.getMetaData();
                if (rsmd != null) {
                    int cols = rsmd.getColumnCount();
                    System.out.println("\n📘 ResultSetMetaData:");
                    for (int i = 1; i <= cols; i++) {
                        System.out.println(rsmd.getColumnName(i) + " - " + rsmd.getColumnTypeName(i));
                    }
                }

                ParameterMetaData pmd = ps.getParameterMetaData();
                System.out.println("📗 Parameter count: " + pmd.getParameterCount());
            }

            // 7️⃣ Clear Parameters Example
            String clearSQL = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(clearSQL)) {
                ps.setInt(1, 4);
                ps.setString(2, "Nisha");
                ps.setInt(3, 88);
                ps.clearParameters(); // clears previous values
                System.out.println("✅ Parameters cleared (example shown).");
            }

            // 8️⃣ Check Valid Connection
            System.out.println("🔍 Connection valid: " + con.isValid(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
