package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.BasicEvaluation;
import ch.hearc.ig.guideresto.business.Restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BasicEvaluationMapper extends AbstractDataMapper<BasicEvaluation>{
    public BasicEvaluationMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected BasicEvaluation mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        LocalDate visitDate = resultSet.getDate("DATE_EVAL").toLocalDate();
        boolean likeRestaurant = resultSet.getString("APPRECIATION").charAt(0) == 'T';
        String ipAddress = resultSet.getString("ADDRESSE_IP");
        Restaurant restaurant = new RestaurantMapper(connection).findById(resultSet.getInt("FK_REST"));
        return new BasicEvaluation(id, visitDate, restaurant, likeRestaurant, ipAddress);

    }

    @Override
    protected String getTableName() {
        return "LIKES";
    }

    @Override
    protected String getColonneName() {
        return "NUMERO";
    }
}
