package ch.hearc.ig.guideresto.service;

import java.util.Scanner;
import ch.hearc.ig.guideresto.persistence.OracleConnection;

public class OracleConnectionService {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String jdbcUrl = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        OracleConnection.setConnectionDetails(jdbcUrl, username, password);

        if (OracleConnection.testConnection()) {
            System.out.println("Database connection successful!");

        } else {
            System.err.println("Failed to establish a database connection. Please check your connection details.");
        }
    }
}