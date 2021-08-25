package com.pictet.technologies.opensource.graphqldemo.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.*;

@Component
@Order(1)
public class MyProjectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.setHeader(ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
        response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET,POST,PATCH,DELETE,PUT,OPTIONS");
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "*");
        response.setHeader(ACCESS_CONTROL_MAX_AGE, "86400");
        chain.doFilter(req, res);
    }
}
