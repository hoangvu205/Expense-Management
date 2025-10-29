package javaqlkd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private final String serverName = "localhost";
    private final String portNumber = "1433";
    private final String dbName = "temp";
    private final String userID = "sa";
    private final String password = "123";
    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                   + ";databaseName=" + dbName
                   + ";encrypt=true;trustServerCertificate=true";
        return DriverManager.getConnection(url, userID, password);
    }
}
