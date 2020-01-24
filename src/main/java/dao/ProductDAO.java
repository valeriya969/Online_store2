package dao;

import entity.Category;
import entity.Product;
import jdbc.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product,Integer>{
    public static final String SQL_SELECT_PRODUCT_CATEGORY =
            "SELECT products.id, products.name, products.price, products.rating FROM products "+
            "JOIN categories ON products.id_c=categories.id " +
                    "WHERE categories.id=?";

    public List<Product> findByIdCategory(String id_c){
        int c =Integer.parseInt(id_c);
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement( SQL_SELECT_PRODUCT_CATEGORY)) {
            statement.setInt(1, c);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price  = rs.getInt(3);
                double rating = rs.getDouble(4);
                products.add(new Product(id, name,price,rating));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return products;
    }

    public static final String SQL_SELECT_PRODUCT =
            "SELECT * FROM products";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_PRODUCT);
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
    public static final String SQL_SELECT_PRODUCT_ORDER_ITEM =
            "SELECT products.id, products.name, products.price, products.rating FROM products "+
                    "JOIN order_item ON products.id=order_item.id_p " +
                    "WHERE order_item.id_o=?";
    public List<Product> findProductInOrderItem(int id_o){
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement( SQL_SELECT_PRODUCT_ORDER_ITEM)) {
            statement.setInt(1, id_o);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price  = rs.getInt(3);
                double rating = rs.getDouble(4);
                products.add(new Product(id, name,price,rating));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return products;
    }



}
