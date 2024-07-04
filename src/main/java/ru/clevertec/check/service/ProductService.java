package ru.clevertec.check.service;

import ru.clevertec.check.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProductById(long id);
    List<Product> getAllProducts();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long id);
}

