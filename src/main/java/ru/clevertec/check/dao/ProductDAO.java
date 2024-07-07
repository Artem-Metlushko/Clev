package ru.clevertec.check.dao;

import ru.clevertec.check.entity.Product;
import ru.clevertec.check.mapper.ProductMapper;
import ru.clevertec.check.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;


public class ProductDAO implements Dao {
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (description, price, quantity_in_stock, wholesale_product) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT id, description, price, quantity_in_stock, wholesale_product FROM product WHERE id = ?";
    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE id = ?";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product SET description = ?, price = ?, quantity_in_stock = ?, wholesale_product = ? WHERE id = ?";

    public Product addProduct(Product product) {
        Product savedProduct = null;
        try (var connection = ConnectionManager.get();
             var ps = connection.prepareStatement(INSERT_PRODUCT_SQL, RETURN_GENERATED_KEYS)) {
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getQuantity());
            ps.setBoolean(4, product.isWholesale());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long id = generatedKeys.getLong(1);
                        savedProduct = Product.builder()
                                .id(id)
                                .price(product.getPrice())
                                .quantity(product.getQuantity())
                                .description(product.getDescription())
                                .wholesale(product.isWholesale())
                                .build();
                    }
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return savedProduct;
    }


    public Optional<Product> getProductById(long id) {
        Optional<Product> product = null;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                product = Optional.of(ProductMapper.mapRowToProduct(rs));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(ProductMapper.mapRowToProduct(rs));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public boolean deleteProduct(long id)  {
        boolean rowDeleted = false;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }


    public boolean updateProduct(Product product)  {
        boolean rowUpdated = false;
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            statement.setString(1, product.getDescription());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setBoolean(4, product.isWholesale());
            statement.setLong(5, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}


