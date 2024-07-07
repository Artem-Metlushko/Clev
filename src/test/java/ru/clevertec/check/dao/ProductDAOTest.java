package ru.clevertec.check.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.check.util.ConnectionManagerForTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class ProductDAOTest {

    private static final String CREATE_TABLE = """
            DROP TABLE IF EXISTS "product";
            CREATE TABLE IF NOT EXISTS "product"
            (
                id BIGSERIAL PRIMARY KEY,
                description VARCHAR(50),
                price DECIMAL,
                quantity_in_stock INTEGER,
                wholesale_product BOOLEAN
            );
            """;
    @BeforeAll
    static void setUpAll() {

        try (Connection connection = ConnectionManagerForTest.get();
             Statement statement = connection.createStatement()
        ) {
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void addProduct() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void updateProduct() {
    }
}