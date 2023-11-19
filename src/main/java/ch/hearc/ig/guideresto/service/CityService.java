package ch.hearc.ig.guideresto.service;

import ch.hearc.ig.guideresto.business.City;
import ch.hearc.ig.guideresto.persistence.CityMapper;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CityService {
    private Connection connection;

    public City findCityById(int cityId) {
        CityMapper cityMapper = new CityMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            City city = cityMapper.findById(cityId);
            connection.commit(); // Commit the transaction
            return city;
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
    public List<City> getAllCities() {
        CityMapper cityMapper = new CityMapper(connection);
        try {
            connection.setAutoCommit(false);
            List<City> cities = cityMapper.findAll();
            connection.commit();
            return cities;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {

            }
            e.printStackTrace();
            return null;
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {

            }
        }
    }

    public boolean createCity(City city) {
        CityMapper cityMapper = new CityMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = cityMapper.insert(city);
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

    public boolean updateCity(City city) {
        CityMapper cityMapper = new CityMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = cityMapper.update(city);
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

    public boolean deleteCity(int cityId) {
        CityMapper cityMapper = new CityMapper(connection);
        try {
            connection.setAutoCommit(false); // Start a transaction
            boolean success = cityMapper.delete(cityId);
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

}
