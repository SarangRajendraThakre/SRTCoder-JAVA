package com.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/secure")
@ServletSecurity(
    value = @HttpConstraint(rolesAllowed = {"admin"}),
    httpMethodConstraints = {
        @HttpMethodConstraint(value = "POST", rolesAllowed = {"manager"})
    }
)
public class SecureServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().println("GET: Only admin allowed");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.getWriter().println("POST: Only manager allowed");
    }
}
