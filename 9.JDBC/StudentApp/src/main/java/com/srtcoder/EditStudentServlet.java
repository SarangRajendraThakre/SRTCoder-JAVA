package com.srtcoder;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        if (sid == null || sid.isEmpty()) {
            out.println("<h3 style='color:red;'>Invalid student ID!</h3>");
            return;
        }

        int id = Integer.parseInt(sid);
        Student s = null;

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                );
            }

        } catch (Exception e) {
            e.printStackTrace(out);
        }

        if (s == null) {
            out.println("<h3 style='color:red;'>Student not found with ID: " + id + "</h3>");
            return;
        }

        // ✅ Forward to JSP with Student object
        request.setAttribute("student", s);
        RequestDispatcher rd = request.getRequestDispatcher("edit_student.jsp");
        rd.forward(request, response);
    }
}
