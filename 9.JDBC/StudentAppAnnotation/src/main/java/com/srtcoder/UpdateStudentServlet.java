package com.srtcoder;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/udpate")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE students SET name=?, email=?, course=? WHERE id=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("view");
    }
}
