package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private final String USERNAME = "root1";
    private final String PASSWORD = "root";

    public Connection getConnection()  {
        Connection connection = null;
        try  {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("connection error");
        }
        return connection;

    }
}
