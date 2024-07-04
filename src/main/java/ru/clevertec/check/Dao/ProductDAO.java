package ru.clevertec.check.Dao;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class ProductDAO implements Dao {

    private final Map<Long, Product> productMap ;


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

