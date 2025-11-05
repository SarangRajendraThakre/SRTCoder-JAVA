package com.srtCoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session != null) session.invalidate();

        Cookie ck = new Cookie("username", "");
        ck.setMaxAge(0);
        res.addCookie(ck);

        res.sendRedirect("login.jsp");
    }
}
