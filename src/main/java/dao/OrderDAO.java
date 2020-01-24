package dao;

import entity.Order;

import java.util.List;

public class OrderDAO extends AbstractDAO<Order,Integer> {
    @Override
    public List<Order> findAll() {
        return super.findAll();
    }

    @Override
    public Order findEntityById(Integer id) {
        return super.findEntityById(id);
    }

    @Override
    public boolean deleteFromId(Integer id) {
        return super.deleteFromId(id);
    }

    @Override
    public boolean deleteFromEntity(Order entity) {
        return super.deleteFromEntity(entity);
    }

    @Override
    public boolean create(Order entity) {
        return super.create(entity);
    }

    @Override
    public void update(Order entity) {
        super.update(entity);
    }
}
