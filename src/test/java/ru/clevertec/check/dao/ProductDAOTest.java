package ru.clevertec.check.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.clevertec.check.dto.ArgumentParserDto;
import ru.clevertec.check.entity.Product;
import ru.clevertec.check.factory.FactoryDao;
import ru.clevertec.check.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ProductDAOTest {
    private final ProductDAO productDAO = FactoryDao.getProductDAO();
    private static Product productWithId;

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

    @BeforeEach
    void setUp() {
        productWithId = productDAO.addProduct(getProductWithoutId());
    }

    @AfterEach
    void tearDown() {
        productDAO.deleteProduct(productWithId.getId());
    }

    @Test
    void testAddProduct() throws Exception {

        assertEquals(getProductWithoutId().getDescription(), productWithId.getDescription());
        assertEquals(getProductWithoutId().getPrice(), productWithId.getPrice());
        assertEquals(getProductWithoutId().getQuantity(), productWithId.getQuantity());
    }

    @Test
    void getProductById() {
        Product expectedProduct = productDAO.getProductById(productWithId.getId()).orElseThrow();
        assertEquals(expectedProduct,productWithId);
    }

    @Test
    void testGetAllProducts() throws Exception {


        Product product2 = Product.builder()
                .description("Test Product 2")
                .price(15.0)
                .quantity(50)
                .wholesale(false)
                .build();

        productDAO.addProduct(product2);

        List<Product> products = productDAO.getAllProducts();

        assertEquals(2, products.size());
    }

    @Test
    void deleteProduct() {
        boolean isDeleted = productDAO.deleteProduct(productWithId.getId());

        assertTrue(isDeleted);
    }

    @Test
    void updateProduct() {
        Product upadateProduct = Product.builder()
                .id(productWithId.getId())
                .description("Test Product")
                .price(10.0)
                .quantity(100)
                .wholesale(true)
                .build();

        boolean isUpdated = productDAO.updateProduct(upadateProduct);

        assertTrue(isUpdated);

        Optional<Product> retrievedProduct = productDAO.getProductById(productWithId.getId());
        assertTrue(retrievedProduct.isPresent());
        assertEquals("Test Product", retrievedProduct.get().getDescription());
        assertEquals(10.0, retrievedProduct.get().getPrice());
    }

    private static Product getProductWithoutId() {
        return Product.builder()
                .description("Whiskey Jack Daniels 1l")
                .price(17.19)
                .quantity(20)
                .wholesale(false)
                .build();
    }

}
