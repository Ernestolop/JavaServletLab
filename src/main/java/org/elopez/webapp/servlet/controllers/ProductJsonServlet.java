package org.elopez.webapp.servlet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.elopez.webapp.servlet.models.Product;
import org.elopez.webapp.servlet.services.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product.json")
public class ProductJsonServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(products);
        response.getWriter().write(json);
    }

    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletInputStream jsonStream = request.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(jsonStream, Product.class);

        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()) {
            out.println("<h1>Product</h1>");
            out.println("<p>Id: " + product.getId() + "</p>");
            out.println("<p>Name: " + product.getName() + "</p>");
            out.println("<p>Type: " + product.getType() + "</p>");
            out.println("<p>Price: " + product.getPrice() + "</p>");
        }
    }
}
