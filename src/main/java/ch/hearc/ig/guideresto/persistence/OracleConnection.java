package ch.hearc.ig.guideresto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    private static Connection connection;
    private static String jdbcUrl= "jdbc:oracle:thin:@db.ig.he-arc.ch:1521:ens";
    private static String username;
    private static String password;

    public static void setConnectionDetails(String jdbcUrl, String username, String password) {
        OracleConnection.jdbcUrl = jdbcUrl;
        OracleConnection.username = username;
        OracleConnection.password = password;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {

                Class.forName("oracle.jdbc.OracleDriver");

                connection = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static boolean testConnection() {
        Connection testConnection = getConnection();
        return testConnection != null;
    }
}
