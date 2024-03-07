package org.elopez.webapp.servlet;

import java.io.IOException;
import java.io.Writer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Writer writer = response.getWriter()) {
            writer.write("<h1>Welcome " + name + "</h1>");
            writer.write("<p>Your email is: " + email + "</p>");
            writer.write("<p>Your password is: " + password + "</p>");
        }
    }
}
