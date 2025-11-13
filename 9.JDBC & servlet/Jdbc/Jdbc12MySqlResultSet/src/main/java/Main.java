import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 1️⃣ Database connection details
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/p1";

            // 2️⃣ Connect to MySQL
            con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL Database successfully.");

            st = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
           );

    
            String createTableSQL = "CREATE TABLE IF NOT EXISTS EMP ( EMPNO INT PRIMARY KEY,   ENAME VARCHAR(50),    SAL DOUBLE )   ";
            st.executeUpdate(createTableSQL);
            System.out.println("🧱 Table EMP checked/created.");

            // 4️⃣ Insert initial sample data (only if empty)
            ResultSet checkRs = st.executeQuery("SELECT COUNT(*) FROM EMP");
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
            	st.executeUpdate(
            		    "INSERT INTO EMP (EMPNO, ENAME, SAL) VALUES " +
            		    "(1001, 'RAHUL', 5000), " +
            		    "(1002, 'PRIYA', 6000), " +
            		    "(1003, 'NEHA', 7000)"
            		);

            }

            // 5️⃣ Execute query
            rs = st.executeQuery("SELECT EMPNO, ENAME, SAL FROM EMP");

            // 6️⃣ Display records
            System.out.println("\n📋 Employee Records:");
            while (rs.next()) {
                int empNo = rs.getInt("EMPNO");
                String name = rs.getString("ENAME");
                double salary = rs.getDouble("SAL");
                System.out.println(empNo + " | " + name + " | " + salary);
            }

            // 7️⃣ Scroll backwards
            System.out.println("\n🔁 Reading in reverse order:");
            rs.afterLast();
            while (rs.previous()) {
                System.out.println(rs.getInt("EMPNO") + " | " + rs.getString("ENAME"));
            }

            // 8️⃣ Update a record directly
            rs.first();
            rs.updateDouble("SAL", rs.getDouble("SAL") + 500);
            rs.updateRow();
            System.out.println("\n✅ Updated first record’s salary by +500.");

            // 9️⃣ Insert a new record using ResultSet
            rs.moveToInsertRow();
            rs.updateInt("EMPNO", 929);
            rs.updateString("ENAME", "SARANG");
            rs.updateDouble("SAL", 8000);
            rs.insertRow();
            System.out.println("✅ Inserted new employee row using ResultSet.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}