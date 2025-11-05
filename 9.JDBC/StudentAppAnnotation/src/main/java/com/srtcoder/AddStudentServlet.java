package com.srtcoder;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;


@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO students (name,email,course) VALUES (?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("view");
    }
}
