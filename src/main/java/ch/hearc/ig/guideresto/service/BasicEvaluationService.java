package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.BasicEvaluation;
import ch.hearc.ig.guideresto.persistence.BasicEvaluationMapper;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicEvaluationService {
    private Connection connection;


    public List<BasicEvaluation> getAllBasicEvaluations() {
        BasicEvaluationMapper basicEvaluationMapper = new BasicEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<BasicEvaluation> basicEvaluations = basicEvaluationMapper.findAll();
            connection.commit(); // Commit the transaction
            return basicEvaluations;
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

    public boolean createBasicEvaluation(BasicEvaluation basicEvaluation) {
        BasicEvaluationMapper basicEvaluationMapper = new BasicEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = basicEvaluationMapper.insert(basicEvaluation);
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

    public boolean updateBasicEvaluation(BasicEvaluation basicEvaluation) {
        BasicEvaluationMapper basicEvaluationMapper = new BasicEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = basicEvaluationMapper.update(basicEvaluation);
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

    public boolean deleteBasicEvaluation(int basicEvaluationId) {
        BasicEvaluationMapper basicEvaluationMapper = new BasicEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = basicEvaluationMapper.delete(basicEvaluationId);
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

    public BasicEvaluation findBasicEvaluationById(int basicEvaluationId) {
        BasicEvaluationMapper basicEvaluationMapper = new BasicEvaluationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            BasicEvaluation basicEvaluation = basicEvaluationMapper.findById(basicEvaluationId);
            connection.commit(); // Commit the transaction
            return basicEvaluation;
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
