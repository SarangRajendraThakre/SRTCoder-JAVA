package com.srt;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("[LoggingFilter] Request received at: " + System.currentTimeMillis());
        chain.doFilter(req, res);
    }

    public void destroy() {}
}
