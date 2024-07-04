package ru.clevertec.check.util;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import ru.clevertec.check.entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@RequiredArgsConstructor
public class ReaderCsv {

    private final Map<Long, Product> productMap ;

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
                Product product = Product.builder()
                        .id(id)
                        .description(description)
                        .price(price)
                        .quantity(quantity)
                        .wholesale(wholesale)
                        .build();
                productMap.put(id, product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
