package com.srt;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet; // ✅ You missed this import
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DbServlet
 */
@WebServlet("/DbServlet") // servlet will run at /DbServlet
public class DbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DbServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h2>Hello from DbServlet!</h2>");
        response.getWriter().println("<p>Served at: " + request.getContextPath() + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
