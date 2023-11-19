package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.RestaurantType;
import ch.hearc.ig.guideresto.persistence.RestaurantTypeMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RestaurantTypeService {
    private Connection connection;

    public List<RestaurantType> getAllRestaurantTypes() {
        RestaurantTypeMapper restaurantTypeMapper = new RestaurantTypeMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<RestaurantType> restaurantTypes = restaurantTypeMapper.findAll();
            connection.commit(); // Commit the transaction
            return restaurantTypes;
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

    public boolean createRestaurantType(RestaurantType restaurantType) {
        RestaurantTypeMapper restaurantTypeMapper = new RestaurantTypeMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantTypeMapper.insert(restaurantType);
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

    public boolean updateRestaurantType(RestaurantType restaurantType) {
        RestaurantTypeMapper restaurantTypeMapper = new RestaurantTypeMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantTypeMapper.update(restaurantType);
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

    public boolean deleteRestaurantType(int restaurantTypeId) {
        RestaurantTypeMapper restaurantTypeMapper = new RestaurantTypeMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantTypeMapper.delete(restaurantTypeId);
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

    public RestaurantType findRestaurantTypeById(int restaurantTypeId) {
        RestaurantTypeMapper restaurantTypeMapper = new RestaurantTypeMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            RestaurantType restaurantType = restaurantTypeMapper.findById(restaurantTypeId);
            connection.commit(); // Commit the transaction
            return restaurantType;
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
