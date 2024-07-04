package ru.clevertec.check.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.entity.Product;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;


    @Override
    public Optional<Product> getProductById(long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(long id) {
        productDAO.deleteProduct(id);
    }
}

