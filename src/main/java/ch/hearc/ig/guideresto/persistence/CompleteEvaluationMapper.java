package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.CompleteEvaluation;
import ch.hearc.ig.guideresto.business.Grade;
import ch.hearc.ig.guideresto.business.Restaurant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CompleteEvaluationMapper extends AbstractDataMapper<CompleteEvaluation>{
    public CompleteEvaluationMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected CompleteEvaluation mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        LocalDate visitDate = resultSet.getDate("DATE_EVAL").toLocalDate();
        String comment = resultSet.getString("COMMENTAIRE");
        String username = resultSet.getString("NOM_UTILISATEUR");
        Restaurant restaurant = new RestaurantMapper(connection).findById(resultSet.getInt("FK_REST"));
        return new CompleteEvaluation(id, visitDate, restaurant, comment, username);
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
