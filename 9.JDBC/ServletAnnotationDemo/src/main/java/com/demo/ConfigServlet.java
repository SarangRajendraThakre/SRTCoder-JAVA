package com.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(
    urlPatterns = "/config",
    initParams = {
        @WebInitParam(name = "appName", value = "DemoApp"),
        @WebInitParam(name = "version", value = "1.0")
    }
)
public class ConfigServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String appName = config.getInitParameter("appName");
        String version = config.getInitParameter("version");
        res.setContentType("text/plain;charset=UTF-8");
        res.getWriter().println("App: " + appName + " v" + version);
    }
}
