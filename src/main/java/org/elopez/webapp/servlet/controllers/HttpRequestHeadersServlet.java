package org.elopez.webapp.servlet.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/http-request-headers")
public class HttpRequestHeadersServlet extends HttpServlet {
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String methodHttp = request.getMethod();
        String url = request.getRequestURL().toString();
        String uri = request.getRequestURI();
        //uri = contextPath + servletPath
        String contectPath = request.getContextPath();
        String sevletPath = request.getServletPath();
        //url = scheme + "://" + ip + ":" + port + uri
        String ip = request.getLocalAddr();
        int port = request.getLocalPort();
        String scheme = request.getScheme();
        //host = ip + ":" + port
        String host = request.getHeader("host");
        //informacion del cliente 
        String ipClient = request.getRemoteAddr();
        String hostClient = request.getRemoteHost();
        int portClient = request.getRemotePort();
        String userAgent = request.getHeader("user-agent");

        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Request Headers</h1>");
            out.println("<p>Method: " + methodHttp + "</p>");
            out.println("<p>URI: " + uri + "</p>");
            out.println("<p>URL: " + url + "</p>");
            out.println("<p>Context Path: " + contectPath + "</p>");
            out.println("<p>Servlet Path: " + sevletPath + "</p>");
            out.println("<p>IP: " + ip + "</p>");
            out.println("<p>Port: " + port + "</p>");
            out.println("<p>Scheme: " + scheme + "</p>");
            out.println("<p>Host: " + host + "</p>");
            out.println("<p>Client IP: " + ipClient + "</p>");
            out.println("<p>Client Host: " + hostClient + "</p>");
            out.println("<p>Client Port: " + portClient + "</p>");
            out.println("<p>User Agent: " + userAgent + "</p>");

            out.println("<h2>Request Headers Iterando</h2>");
            out.println("<ul>");
            request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
                out.println("<li>" + headerName + ": " + request.getHeader(headerName) + "</li>");
            });
        }
    }
}
