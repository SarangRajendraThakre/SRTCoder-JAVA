package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        Student s = new Student(name, email, pass);
        StudentDAO dao = new StudentDAO();
        boolean ok = dao.addStudent(s);

        if (ok) res.sendRedirect("login.jsp");
        else res.getWriter().println("Registration failed");
    }
}
