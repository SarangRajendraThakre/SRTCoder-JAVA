package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;

public class StudentEditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            StudentDAO dao = new StudentDAO();
            Student s = dao.getStudentById(Integer.parseInt(id));
            req.setAttribute("student", s);
            RequestDispatcher rd = req.getRequestDispatcher("edit-student.jsp");
            rd.forward(req, res);
            return;
        }
        res.sendRedirect("students");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Student s = new Student();
        s.setId(Integer.parseInt(req.getParameter("id")));
        s.setName(req.getParameter("name"));
        s.setEmail(req.getParameter("email"));

        StudentDAO dao = new StudentDAO();
        dao.updateStudent(s);
        res.sendRedirect("students");
    }
}
