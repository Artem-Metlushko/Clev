package ru.clevertec.check.service;

import ru.clevertec.check.dao.ProductDAO;
import ru.clevertec.check.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductService implements Service {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Optional<Product> getProductById(long id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }


    public Product addProduct(Product product) {
        return productDAO.addProduct(product);
    }


    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }


    public boolean deleteProduct(long id) {
        return productDAO.deleteProduct(id);
    }
}

