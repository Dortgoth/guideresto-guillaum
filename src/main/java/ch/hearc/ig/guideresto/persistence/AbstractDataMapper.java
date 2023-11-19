package ch.hearc.ig.guideresto.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbstractDataMapper<T> implements DataMapper<T> {
    protected Connection connection;
    protected Map<Integer, T> currentResults;
    protected AbstractDataMapper(Connection connection) {
        this.connection = connection;
    }

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected abstract String getTableName();

    protected abstract String getColonneName();
    @Override
    public T findById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM " + getTableName() + " WHERE " + getColonneName() + " = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return mapResultSetToEntity(resultSet);
    }

    @Override
    public List<T> findAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM " + getTableName());
        return new ArrayList<>();
    }

    @Override
    public boolean insert(T entity) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO " + getTableName() + " VALUES (?)");
            statement.setString(1, entity.toString());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public boolean update(T entity) {
        PreparedStatement preparedStatement = null;

        try {
            // Create an SQL update statement based on your entity and table structure
            // You'll need to customize this based on your specific entity and table
            String updateSql = "UPDATE " + getTableName() + " SET column1=?, column2=?, ... WHERE primaryKeyColumn=?";
            preparedStatement = connection.prepareStatement(updateSql);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }



    @Override
    public boolean delete(long id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "DELETE FROM " + getTableName() + " WHERE " + getColonneName() + " = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public T findByName(String name) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * FROM " + getTableName() + " WHERE " + getColonneName() + " = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return currentResults.get(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
