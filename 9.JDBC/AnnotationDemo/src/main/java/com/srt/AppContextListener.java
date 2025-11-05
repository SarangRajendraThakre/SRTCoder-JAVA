package com.srt;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebListener
public class AppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[AppContextListener] Application started!");
    }
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[AppContextListener] Application stopped!");
    }
}
