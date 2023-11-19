package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.Localisation;
import ch.hearc.ig.guideresto.business.City;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalisationMapper extends AbstractDataMapper<Localisation>{
    private DataMapper<City> cityDataMapper = new CityMapper(connection);
    public LocalisationMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected Localisation mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String street = resultSet.getString("STREET");
        Integer cityId = resultSet.getInt("CITY_ID");
        City city = cityDataMapper.findById(resultSet.getInt(cityId));
        return new Localisation(street, city);
    }

    @Override
    protected String getTableName() {
        return "LOCALISATIONS";
    }

    @Override
    protected String getColonneName() {
        return "LOCALISATION_ID";
    }
}
