package dao;

import entity.OrderItem;
import entity.User;
import jdbc.ConnectorDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDAO extends AbstractDAO<OrderItem,Integer> {
    @Override
    public List<OrderItem> findAll() {
        return super.findAll();
    }


//    public static final String SQL_SELECT_ORDER_ITEM_ID =
//            "SELECT  FROM order_item WHERE id=?";
//    @Override
//    public OrderItem findEntityById(Integer id) {
//        OrderItem orderItem = null;
//        try (Connection connection = ConnectorDB.getConnection();
//             PreparedStatement statement =
//                     connection.prepareStatement(SQL_SELECT_ORDER_ITEM_ID)) {
//            statement.setInt(1, id);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                id = rs.getInt(1);
//                String name = rs.getString(2);
//                category = new Category(id, name);
//            }
//        } catch (SQLException e) {
//            System.err.println("SQL Exception (request or table failed):" + e);
//        }
//        return orderItem;
//
//    }

    @Override
    public boolean deleteFromId(Integer id) {
        return super.deleteFromId(id);
    }

    @Override
    public boolean deleteFromEntity(OrderItem entity) {
        return super.deleteFromEntity(entity);
    }

    @Override
    public boolean create(OrderItem entity) {
        return super.create(entity);
    }

    public static final String INSERT_QUERY =
            "INSERT INTO order_item (id_o, id_p) VALUES (?,?)";

    @Override
    public void update(OrderItem entity) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_QUERY)){
            preparedStatement.setInt(1,entity.getId());
            preparedStatement.setInt(2,entity.getId_p());
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}
