package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.business.City;
import ch.hearc.ig.guideresto.business.RestaurantType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper extends AbstractDataMapper<Restaurant>{
    public RestaurantMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected Restaurant mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        String name = resultSet.getString("NOM");
        String description = resultSet.getString("DESCRIPTION");
        String address = resultSet.getString("ADRESSE");
        Integer typeId = resultSet.getInt("FK_TYPE");
        Integer cityId = resultSet.getInt("FK_VILL");;
        City city = new CityMapper(connection).findById(resultSet.getInt("FK_VILL"));
        RestaurantType type = new RestaurantTypeMapper(connection).findById(resultSet.getInt("FK_TYPE"));
        String website = resultSet.getString("SITE_WEB");
    return new Restaurant(id, name, description, website, address, city, type);
    }

    @Override
    protected String getTableName() {
        return "RESTAURANTS";
    }

    @Override
    protected String getColonneName() {
        return "NUMERO";
    }
}
