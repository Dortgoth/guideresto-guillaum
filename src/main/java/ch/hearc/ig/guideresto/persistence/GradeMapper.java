package ch.hearc.ig.guideresto.persistence;
import ch.hearc.ig.guideresto.business.EvaluationCriteria;
import ch.hearc.ig.guideresto.business.Grade;
import ch.hearc.ig.guideresto.business.CompleteEvaluation;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeMapper extends AbstractDataMapper<Grade> {
    public GradeMapper(Connection connection) {
        super(connection);
    }

    @Override
    protected Grade mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("NUMERO");
        Integer grade = resultSet.getInt("NOTE");
        CompleteEvaluation evaluation = new CompleteEvaluationMapper(connection).findById(resultSet.getInt("FK_COMM"));
        EvaluationCriteria criteria = new EvaluationCriteriaMapper(connection).findById(resultSet.getInt("FK_CRIT"));
        return new Grade(id, grade, evaluation, criteria);
    }

    @Override
    protected String getTableName() {
        return "NOTE";
    }

    @Override
    protected String getColonneName() {
        return "NUMERO";
    }
}
