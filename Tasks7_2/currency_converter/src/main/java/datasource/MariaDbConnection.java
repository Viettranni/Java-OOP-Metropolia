package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This package contains the code for connecting to the database.

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/currency_db";
    private static final String USER = "appuser";
    private static final String PASSWORD = "moi";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
            return null; // or throw a runtime exception
        }
    }

    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
