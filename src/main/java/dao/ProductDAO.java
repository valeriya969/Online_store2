package dao;

import entity.Product;
import entity.User;
import jdbc.ConnectorDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product,Integer>{
    public static final String SQL_SELECT_PRODUCT_CATEGORY =
            "SELECT * FROM products p"+
            "JOIN categories c ON p.id_c=c.id " +
                    "WHERE c.id=?";
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_PRODUCT_CATEGORY);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(3);
                int price  = rs.getInt(4);
                double rating = rs.getDouble(5);
                products.add(new Product(id, name,price,rating));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return products;
    }
}
