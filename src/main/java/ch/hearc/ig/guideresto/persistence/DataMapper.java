package ch.hearc.ig.guideresto.persistence;

import java.sql.SQLException;
import java.util.List;

public interface DataMapper<T> {
    public T findById(Integer id) throws SQLException;
    public T findByName(String name);
    public List<T> findAll() throws SQLException;
    public boolean update(T entity) throws SQLException;
    public void delete(long id);
    public void insert(T entity) throws SQLException;
}
