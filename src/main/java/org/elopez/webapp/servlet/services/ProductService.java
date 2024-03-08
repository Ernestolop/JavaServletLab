package org.elopez.webapp.servlet.services;

import java.util.List;
import org.elopez.webapp.servlet.models.Product;

public interface ProductService {
    List<Product> findAll();
}
