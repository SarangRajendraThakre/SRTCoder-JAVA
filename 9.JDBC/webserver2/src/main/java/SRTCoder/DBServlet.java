package SRTCoder;


import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL (no DB yet)
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            // Create Database if not exists
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS p1");
            out.println("✅ Database 'p1' created or exists.<br>");

            // Connect to DB
            con = DriverManager.getConnection(url + "p1", user, password);
            st = con.createStatement();

            // Create Table
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS EMP (
                    EMPNO INT PRIMARY KEY AUTO_INCREMENT,
                    ENAME VARCHAR(50),
                    SAL DOUBLE
                )
            """);
            out.println("✅ Table 'EMP' created or exists.<br>");

            // Insert Data
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM EMP");
            rs.next();
            if (rs.getInt(1) == 0) {
                st.executeUpdate("""
                    INSERT INTO EMP (ENAME, SAL) VALUES
                    ('Sarang', 70000),
                    ('Priya', 80000),
                    ('Neha', 75000)
                """);
                out.println("✅ Data inserted.<br>");
            }

            // Display Data
            rs = st.executeQuery("SELECT * FROM EMP");
            out.println("<h3>📋 Employee Data</h3>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("EMPNO") + "</td><td>" +
                        rs.getString("ENAME") + "</td><td>" +
                        rs.getDouble("SAL") + "</td></tr>");
            }
            out.println("</table>");

            con.close();
        } catch (Exception e) {
            out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        }
    }
}
