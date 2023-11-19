package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.Localisation;
import ch.hearc.ig.guideresto.persistence.LocalisationMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LocalisationService {
    private Connection connection;


    public List<Localisation> getAllLocalisations() {
        LocalisationMapper localisationMapper = new LocalisationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<Localisation> localisations = localisationMapper.findAll();
            connection.commit(); // Commit the transaction
            return localisations;
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

    public boolean createLocalisation(Localisation localisation) {
        LocalisationMapper localisationMapper = new LocalisationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = localisationMapper.insert(localisation);
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

    public boolean updateLocalisation(Localisation localisation) {
        LocalisationMapper localisationMapper = new LocalisationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = localisationMapper.update(localisation);
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

    public boolean deleteLocalisation(int localisationId) {
        LocalisationMapper localisationMapper = new LocalisationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = localisationMapper.delete(localisationId);
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

    public Localisation findLocalisationById(int localisationId) {
        LocalisationMapper localisationMapper = new LocalisationMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            Localisation localisation = localisationMapper.findById(localisationId);
            connection.commit(); // Commit the transaction
            return localisation;
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
