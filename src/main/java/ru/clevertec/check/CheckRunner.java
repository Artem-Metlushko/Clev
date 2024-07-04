package ru.clevertec.check;

import ru.clevertec.check.Dao.ProductDAO;
import ru.clevertec.check.Dao.ProductDAOImpl;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.service.ProductService;
import ru.clevertec.check.service.ProductServiceImpl;
import ru.clevertec.check.util.ReaderCsv;

import java.util.HashMap;
import java.util.Map;

public class CheckRunner {
    public static void main(String[] args) {
        Map<Long, Product> productMap = new HashMap<>();

        ProductDAO productDAO = new ProductDAOImpl(productMap);
        ProductService productService = new ProductServiceImpl(productDAO);

        String csvFilePath = "src/main/resources/products.csv";
        ReaderCsv readerCsv = new ReaderCsv(productMap);
        readerCsv.loadProducts(csvFilePath);


        productService.getAllProducts().forEach(System.out::println);
    }
}
