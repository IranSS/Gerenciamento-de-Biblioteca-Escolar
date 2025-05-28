package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static String USER = "root";
    private static String PASSWORD = "8569";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
