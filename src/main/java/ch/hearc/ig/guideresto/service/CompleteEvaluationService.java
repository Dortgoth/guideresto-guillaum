package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.CompleteEvaluation;
import ch.hearc.ig.guideresto.persistence.CompleteEvaluationMapper;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CompleteEvaluationService {
    private Connection connection;


    public List<CompleteEvaluation> getAllCompleteEvaluations() {
        CompleteEvaluationMapper evaluationMapper = new CompleteEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<CompleteEvaluation> evaluations = evaluationMapper.findAll();
            connection.commit(); // Commit the transaction
            return evaluations;
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

    public boolean createCompleteEvaluation(CompleteEvaluation evaluation) {
        CompleteEvaluationMapper evaluationMapper = new CompleteEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = evaluationMapper.insert(evaluation);
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

    public boolean updateCompleteEvaluation(CompleteEvaluation evaluation) {
        CompleteEvaluationMapper evaluationMapper = new CompleteEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = evaluationMapper.update(evaluation);
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

    public boolean deleteCompleteEvaluation(int evaluationId) {
        CompleteEvaluationMapper evaluationMapper = new CompleteEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = evaluationMapper.delete(evaluationId);
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

    public CompleteEvaluation findCompleteEvaluationById(int evaluationId) {
        CompleteEvaluationMapper evaluationMapper = new CompleteEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            CompleteEvaluation evaluation = evaluationMapper.findById(evaluationId);
            connection.commit(); // Commit the transaction
            return evaluation;
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
