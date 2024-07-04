package ru.clevertec.check.util;

import ru.clevertec.check.entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;


public class ProductReaderCsv {

    private final Map<Long, Product> productMap ;

    public ProductReaderCsv(Map<Long, Product> productMap) {
        this.productMap = productMap;
    }

    public void loadProducts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                long id = Long.parseLong(values[0]);
                String description = values[1];
                double price = Double.parseDouble(values[2].replace(",", ".").trim());
                int quantity = Integer.parseInt(values[3]);
                boolean wholesale = values[4].trim().equals("+");
                Product product = getProduct(id, description, price, quantity, wholesale);
                productMap.put(id, product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Product getProduct(long id, String description, double price, int quantity, boolean wholesale) {
        return Product.builder()
                .id(id)
                .description(description)
                .price(price)
                .quantity(quantity)
                .wholesale(wholesale)
                .build();
    }



}
