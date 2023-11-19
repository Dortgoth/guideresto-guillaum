package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.BasicEvaluation;
import ch.hearc.ig.guideresto.business.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BasicEvaluationMapper extends AbstractDataMapper<BasicEvaluation> {
    protected BasicEvaluationMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected BasicEvaluation mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        LocalDate visitedate = resultSet.getDate("DATE_EVAL").toLocalDate();
        Restaurant restaurant = new RestaurantMapper(connection).findById(resultSet.getInt("FK_RESTAURANT"));
        boolean likeRestaurant = resultSet.getString("APPRECIATION").charAt(0) == 'T';
        String ipAddress = resultSet.getString("IP_ADDRESS");
        return new BasicEvaluation(id, visitedate, restaurant, likeRestaurant, ipAddress);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected String getColonneName() {
        return null;
    }
}
