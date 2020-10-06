import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHandler extends Configs {
    Connection dbConection;

    public Connection getDbConection() throws SQLException {

        Properties prop = new Properties();
        prop.setProperty("useSSL", "false");
        prop.setProperty("serverTimezone", "Europe/Kiev");
        prop.setProperty("user", dbUser);
        prop.setProperty("password", dbPass);

        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        dbConection = DriverManager.getConnection(connectionString, prop);
        System.out.println("connection successful");
        return dbConection;
    }

}
