package ch.hearc.ig.guideresto.persistence;

import ch.hearc.ig.guideresto.business.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityMapper extends AbstractDataMapper<City> {

    public CityMapper(Connection connection) {
        super(connection);
    }

    protected City mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        String name = resultSet.getString("NOM_VILLE");
        String zipCode = resultSet.getString("CODE_POSTAL");
        return new City(id, name, zipCode);
    }

    protected String getTableName() {
        return "VILLES";
    }
    protected String getColonneName() {
        return "NUMERO";
    }

}
