package dao;

import entity.OrderItem;
import entity.User;
import jdbc.ConnectorDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User,Integer> {
    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String login = rs.getString(2);
                users.add(new User(id, login));
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return users;
    }

    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM users WHERE id=?";
    @Override
    public User findEntityById(Integer id) {
        User user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                String name = rs.getString(2);
                user = new User(id, name);
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception (request or table failed):" + e);
        }
        return user;
    }


    public static final String INSERT_QUERY =
            "INSERT INTO users (login, password) VALUES (?,?)";

    public void updateUser(User entity) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_QUERY,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,entity.getLogin());
            preparedStatement.setString(2,entity.getPassword());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                entity.setId(resultSet.getInt(1));
                entity.getOrderItem().setId(resultSet.getInt(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
}
