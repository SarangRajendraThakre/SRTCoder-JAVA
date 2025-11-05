package com.srtcoder;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;


@WebServlet("/view")
public class ViewStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Student> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("course")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Important: set the list to request
        req.setAttribute("studentList", list);

        // ✅ Forward to JSP
        RequestDispatcher rd = req.getRequestDispatcher("view_students.jsp");
        rd.forward(req, res);
    }
}
