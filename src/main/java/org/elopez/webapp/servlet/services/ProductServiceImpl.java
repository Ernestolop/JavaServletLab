package org.elopez.webapp.servlet.services;

import java.util.Arrays;
import java.util.List;
import org.elopez.webapp.servlet.models.Product;

public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl() {}

    @Override
    public List<Product> findAll() {
        return Arrays.asList(
            new Product(1L, "Product 1", "Type 1", 100),
            new Product(2L, "Product 2", "Type 2", 200),
            new Product(3L, "Product 3", "Type 3", 300)
        );
    }
}
