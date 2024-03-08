package org.elopez.webapp.servlet.controllers;

import org.elopez.webapp.servlet.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.elopez.webapp.servlet.models.Product;

@WebServlet({"/product.xls", "/product.html"})
public class ProductXlsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.findAll();

        String servletPath = request.getServletPath();
        if (servletPath.equals("/product.xls")) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=products.xls");
        } else {
            response.setContentType("text/html");
        }

        try(PrintWriter out = response.getWriter()) {
            out.println(); 
            if (servletPath.equals("/product.html")) {
                out.println("<h1>Products</h1>");
                out.println("<a href=\"" + request.getContextPath() + "/product.xls\">Export to XLS</a>");
                out.println("<a href=\"" + request.getContextPath() + "/product.json\">ver en formato JSON</a>");
            }
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Name</th>");
            out.println("<th>Type</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");
            for (Product product : products) {
                out.println("<tr>");
                out.println("<td>" + product.getId() + "</td>");
                out.println("<td>" + product.getName() + "</td>");
                out.println("<td>" + product.getType() + "</td>");
                out.println("<td>" + product.getPrice() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }         
}
