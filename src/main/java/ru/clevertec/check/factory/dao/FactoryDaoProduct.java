package ru.clevertec.check.factory.dao;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.Dao.Dao;
import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.entity.Product;

import java.util.Map;

@RequiredArgsConstructor
public class FactoryDaoProduct extends FactoryDaoAbstract {
    private final Map<Long, Product> productMap;

    @Override
    public Dao createDao() {
        return new ProductDAO(productMap);
    }
}

