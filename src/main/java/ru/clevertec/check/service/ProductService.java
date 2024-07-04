package ru.clevertec.check.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.entity.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductService implements Service {

    private final ProductDAO productDAO;

    public Optional<Product> getProductById(long id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }


    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }


    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }


    public void deleteProduct(long id) {
        productDAO.deleteProduct(id);
    }
}

