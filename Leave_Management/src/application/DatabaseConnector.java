package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Load the MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/Leave_Management";
        String username = "root";
        String password = "naga/888";

        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}
