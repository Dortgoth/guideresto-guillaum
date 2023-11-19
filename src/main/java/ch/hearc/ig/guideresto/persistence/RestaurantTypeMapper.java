package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.RestaurantType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantTypeMapper extends AbstractDataMapper<RestaurantType> {
    public RestaurantTypeMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected RestaurantType mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        String libelle = resultSet.getString("LIBELLE");
        String description = resultSet.getString("DESCRIPTION");
        return new RestaurantType(id, libelle, description);
    }


    @Override
    protected String getTableName() {
        return "TYPES_GASTRONOMIQUES";
    }

    @Override
    protected String getColonneName() {
        return "NUMERO";
    }
}
