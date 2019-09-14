package dao;

import java.util.List;

public interface DAOStore<T,K > {
    List<T> findAll();

    T findEntityById(K id);

    boolean deleteFromId(K id);

    boolean deleteFromEntity(T entity);

    boolean create(T entity);

    void update(T entity);
}
