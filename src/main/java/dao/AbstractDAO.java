package dao;

import java.util.List;

public abstract class AbstractDAO<T ,K extends Number> implements DAOStore<T ,K> {
    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findEntityById(K id) {
        return null;
    }

    @Override
    public boolean deleteFromId(K id) {
        return false;
    }

    @Override
    public boolean deleteFromEntity(T entity) {
        return false;
    }

    @Override
    public boolean create(T entity) {
        return false;
    }

    @Override
    public void update(T entity) {
    }
}
