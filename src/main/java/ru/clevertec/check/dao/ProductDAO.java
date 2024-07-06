package ru.clevertec.check.dao;

import ru.clevertec.check.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ProductDAO implements Dao {

    private final Map<Long, Product> productMap;

    public ProductDAO(Map<Long, Product> productMap) {
        this.productMap = productMap;
    }


    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(productMap.get(id));
    }


    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }


    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }


    public void updateProduct(Product product) {
        productMap.put(product.getId(), product);
    }


    public void deleteProduct(long id) {
        productMap.remove(id);
    }
}

