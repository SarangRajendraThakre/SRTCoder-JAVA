package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username != null && !username.isEmpty()) {
            StudentDAO dao = new StudentDAO();
            boolean ok = dao.loginUser(username, password);
            if (ok) {
                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                res.sendRedirect("students");
                return;
            } else {
                res.sendRedirect("login.jsp?error=1");
                return;
            }
        }

        String email = req.getParameter("email");
        StudentDAO dao = new StudentDAO();
        Student s = dao.loginStudent(email, password);
        if (s != null) {
            HttpSession session = req.getSession();
            session.setAttribute("student", s);
            Cookie ck = new Cookie("username", s.getName());
            ck.setMaxAge(60*60);
            ck.setHttpOnly(true);
            res.addCookie(ck);
            res.sendRedirect("students");
        } else {
            res.sendRedirect("login.jsp?error=1");
        }
    }
}
