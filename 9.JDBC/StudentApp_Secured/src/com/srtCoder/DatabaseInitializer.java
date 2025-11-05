package com.srtCoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // connect to MySQL server (no DB)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC", "root", "root");
            Statement st = con.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS studentdb");
            st.close();
            con.close();

            // connect to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC", "root", "root");
            st = con.createStatement();

            // create users table
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) NOT NULL UNIQUE,
                    password VARCHAR(255) NOT NULL
                )
            """);

            // create students table
            st.executeUpdate("""
                CREATE TABLE IF NOT EXISTS students (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE,
                    password VARCHAR(255) NOT NULL,
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
            """);

            // insert sample admin into users if not exists (hashed password)
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM users");
            rs.next();
            if (rs.getInt(1) == 0) {
                String adminPass = PasswordUtil.hashPassword("admin");
                st.executeUpdate("INSERT INTO users (username, password) VALUES ('admin', '" + adminPass + "')");
            }
            rs.close();

            // insert sample students if none
            rs = st.executeQuery("SELECT COUNT(*) FROM students");
            rs.next();
            if (rs.getInt(1) == 0) {
                String p1 = PasswordUtil.hashPassword("pass1");
                String p2 = PasswordUtil.hashPassword("pass2");
                st.executeUpdate("INSERT INTO students (name,email,password) VALUES ('Rahul Sharma','rahul@example.com','"+p1+"')");
                st.executeUpdate("INSERT INTO students (name,email,password) VALUES ('Priya Patel','priya@example.com','"+p2+"')");
            }
            rs.close();

            st.close();
            con.close();
            System.out.println("Database initialization completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // No-op
    }
}
