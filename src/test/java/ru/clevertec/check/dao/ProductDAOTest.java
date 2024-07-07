package ru.clevertec.check.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.factory.FactoryDao;
import ru.clevertec.check.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class ProductDAOTest {
    private final ProductDAO productDAO = FactoryDao.getProductDAO();

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
        ArgumentParserDto argumentParserDto = ArgumentParserDto.builder()
                .dataSourceUrl("jdbc:postgresql://localhost:54321/productstestdb")
                .dataSourcePassword("testpassword")
                .dataSourceUserName("testuser")
                .build();
        ConnectionManager.init(argumentParserDto);

        try (Connection connection = ConnectionManager.get();
             Statement statement = connection.createStatement()
        ) {
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testAddProduct() throws Exception {
        Product product = Product.builder()
                .description("Test Product")
                .price(10.0)
                .quantity(100)
                .wholesale(true)
                .build();

        Product savedProduct = productDAO.addProduct(product);

        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("Test Product", savedProduct.getDescription());
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