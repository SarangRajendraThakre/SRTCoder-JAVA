package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class StudentDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            StudentDAO dao = new StudentDAO();
            dao.deleteStudent(Integer.parseInt(id));
        }
        res.sendRedirect("students");
    }
}
