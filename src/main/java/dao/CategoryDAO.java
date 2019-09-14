package dao;

import entity.Category;
import jdbc.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category,Integer> {
    public static final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM categories";
    public static final String SQL_SELECT_CATEGORY_ID =
            "SELECT * FROM users WHERE id=?";

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_CATEGORIES);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
               categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return categories;

    }

    @Override
    public Category findEntityById(Integer id) {
        Category category = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_CATEGORY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                String name = rs.getString(2);
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return category;
    }

    @Override
    public boolean create(Category entity) {
        return super.create(entity);
    }
}
