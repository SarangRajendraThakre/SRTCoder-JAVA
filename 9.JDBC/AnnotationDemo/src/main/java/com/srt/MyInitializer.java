package com.srt;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.util.Set;

@HandlesTypes(MyInterface.class)
public class MyInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext ctx) throws ServletException {
        System.out.println("[MyInitializer] onStartup called. Found classes:");
        if (classes != null) {
            for (Class<?> c : classes) {
                System.out.println(" - " + c.getName());
            }
        } else {
            System.out.println(" - (none)");
        }
    }
}
