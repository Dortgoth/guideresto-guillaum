package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.EvaluationCriteria;
import ch.hearc.ig.guideresto.persistence.EvaluationCriteriaMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class EvaluationCriteriaService {
    private Connection connection;


    public List<EvaluationCriteria> getAllEvaluationCriteria() {
        EvaluationCriteriaMapper criteriaMapper = new EvaluationCriteriaMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<EvaluationCriteria> criteriaList = criteriaMapper.findAll();
            connection.commit(); // Commit the transaction
            return criteriaList;
        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback the transaction in case of an error
            } catch (SQLException rollbackException) {
                // Handle rollback exception, log it, or throw it if necessary
            }
            e.printStackTrace(); // Handle or log the exception as needed
            return null;
        } finally {
            try {
                connection.setAutoCommit(true); // Set auto-commit back to true
            } catch (SQLException e) {
                // Handle or log the exception as needed
            }
        }
    }

    public boolean createEvaluationCriteria(EvaluationCriteria criteria) {
        EvaluationCriteriaMapper criteriaMapper = new EvaluationCriteriaMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = criteriaMapper.insert(criteria);
            if (success) {
                connection.commit(); // Commit the transaction if creation is successful
            } else {
                connection.rollback(); // Rollback if creation fails
            }
            return success;
        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback the transaction in case of an error
            } catch (SQLException rollbackException) {
                // Handle rollback exception, log it, or throw it if necessary
            }
            e.printStackTrace(); // Handle or log the exception as needed
            return false;
        } finally {
            try {
                connection.setAutoCommit(true); // Set auto-commit back to true
            } catch (SQLException e) {
                // Handle or log the exception as needed
            }
        }
    }

    public boolean updateEvaluationCriteria(EvaluationCriteria criteria) {
        EvaluationCriteriaMapper criteriaMapper = new EvaluationCriteriaMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = criteriaMapper.update(criteria);
            if (success) {
                connection.commit(); // Commit the transaction if update is successful
            } else {
                connection.rollback(); // Rollback if update fails
            }
            return success;
        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback the transaction in case of an error
            } catch (SQLException rollbackException) {
                // Handle rollback exception, log it, or throw it if necessary
            }
            e.printStackTrace(); // Handle or log the exception as needed
            return false;
        } finally {
            try {
                connection.setAutoCommit(true); // Set auto-commit back to true
            } catch (SQLException e) {
                // Handle or log the exception as needed
            }
        }
    }

    public boolean deleteEvaluationCriteria(int criteriaId) {
        EvaluationCriteriaMapper criteriaMapper = new EvaluationCriteriaMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = criteriaMapper.delete(criteriaId);
            if (success) {
                connection.commit(); // Commit the transaction if deletion is successful
            } else {
                connection.rollback(); // Rollback if deletion fails
            }
            return success;
        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback the transaction in case of an error
            } catch (SQLException rollbackException) {
                // Handle rollback exception, log it, or throw it if necessary
            }
            e.printStackTrace(); // Handle or log the exception as needed
            return false;
        } finally {
            try {
                connection.setAutoCommit(true); // Set auto-commit back to true
            } catch (SQLException e) {
                // Handle or log the exception as needed
            }
        }
    }

    public EvaluationCriteria findEvaluationCriteriaById(int criteriaId) {
        EvaluationCriteriaMapper criteriaMapper = new EvaluationCriteriaMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            EvaluationCriteria criteria = criteriaMapper.findById(criteriaId);
            connection.commit(); // Commit the transaction
            return criteria;
        } catch (SQLException e) {
            try {
                connection.rollback(); // Rollback the transaction in case of an error
            } catch (SQLException rollbackException) {
                // Handle rollback exception, log it, or throw it if necessary
            }
            e.printStackTrace(); // Handle or log the exception as needed
            return null;
        } finally {
            try {
                connection.setAutoCommit(true); // Set auto-commit back to true
            } catch (SQLException e) {
                // Handle or log the exception as needed
            }
        }
    }

}
