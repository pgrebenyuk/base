package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnectionManager {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String DB_NAME = "base1";

    public static Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("useSSL", "false");
        prop.setProperty("serverTimezone", "Europe/Kiev");
        prop.setProperty("user", DB_USER);
        prop.setProperty("password", DB_PASS);
        String connectionString = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

        return DriverManager.getConnection(connectionString, prop);
    }

}
