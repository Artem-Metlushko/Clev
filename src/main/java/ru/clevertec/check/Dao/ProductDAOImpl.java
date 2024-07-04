package ru.clevertec.check.Dao;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private final Map<Long, Product> productMap ;

    @Override
    public Optional<Product> getProductById(long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(long id) {
        productMap.remove(id);
    }
}

