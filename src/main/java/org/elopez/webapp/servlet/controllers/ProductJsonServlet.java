package org.elopez.webapp.servlet.controllers;

import java.io.IOException;
import java.util.List;
import org.elopez.webapp.servlet.models.Product;
import org.elopez.webapp.servlet.services.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
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
}
