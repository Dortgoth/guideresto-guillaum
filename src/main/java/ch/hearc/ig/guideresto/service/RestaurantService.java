package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.Restaurant;
import ch.hearc.ig.guideresto.persistence.RestaurantMapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RestaurantService {
    private Connection connection;


    public List<Restaurant> getAllRestaurants() {
        RestaurantMapper restaurantMapper = new RestaurantMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            List<Restaurant> restaurants = restaurantMapper.findAll();
            connection.commit(); // Commit the transaction
            return restaurants;
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

    public boolean createRestaurant(Restaurant restaurant) {
        RestaurantMapper restaurantMapper = new RestaurantMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantMapper.insert(restaurant);
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

    public boolean updateRestaurant(Restaurant restaurant) {
        RestaurantMapper restaurantMapper = new RestaurantMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantMapper.update(restaurant);
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

    public boolean deleteRestaurant(int restaurantId) {
        RestaurantMapper restaurantMapper = new RestaurantMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = restaurantMapper.delete(restaurantId);
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

    public Restaurant findRestaurantById(int restaurantId) {
        RestaurantMapper restaurantMapper = new RestaurantMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            Restaurant restaurant = restaurantMapper.findById(restaurantId);
            connection.commit(); // Commit the transaction
            return restaurant;
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
