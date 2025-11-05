package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

public class StudentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.getAllStudents();
        req.setAttribute("students", list);
        RequestDispatcher rd = req.getRequestDispatcher("students.jsp");
        rd.forward(req, res);
    }
}
