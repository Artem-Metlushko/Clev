package ru.clevertec.check.mapper;

import ru.clevertec.check.entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper {

    public static Product mapRowToProduct(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String description = rs.getString("description");
        Double price = rs.getDouble("price");
        int quantity = rs.getInt("quantity_in_stock");
        boolean wholesale = rs.getBoolean("wholesale_product");
        return Product.builder()
                .id(id)
                .description(description)
                .price(price)
                .quantity(quantity)
                .wholesale(wholesale)
                .build();
    }

    public static void mapProductToStatement(Product product, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, product.getDescription());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setBoolean(4, product.isWholesale());
    }
}

