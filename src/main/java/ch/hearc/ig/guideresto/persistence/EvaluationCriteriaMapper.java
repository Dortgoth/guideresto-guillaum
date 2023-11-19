package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.EvaluationCriteria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EvaluationCriteriaMapper extends AbstractDataMapper<EvaluationCriteria> {
    public EvaluationCriteriaMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected EvaluationCriteria mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        String name = resultSet.getString("NOM");
        String description = resultSet.getString("DESCRIPTION");
        return new EvaluationCriteria(id, name, description);
    }

    @Override
    protected String getTableName() {
        return "CRITERES_EVALUATION";
    }

    @Override
    protected String getColonneName() {
        return "NUMERO";
    }
}
