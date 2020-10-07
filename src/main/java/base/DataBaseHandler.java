package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//крутіша назва DataBaseConnectionManager
public class DataBaseHandler {
    //ці всі змінні мають бути недоступні ззовні
    //+ ти назвав їх не по конвенція, це мають бути константи
    public static String dbHost = "localhost";
    public static String dbPort = "3306";
    public static String dbUser = "root";
    public static String dbPass = "root";
    public static String dbName = "base1";

    //немає сенсу в цій змінній, так як ти її більше ніяк не використовуєш
    //просто повертай об*єкт з метода нижче
    //тут знов в назві змінної помилка, того і світиться
    public static Connection dbConection;

    public static Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        prop.setProperty("useSSL", "false");
        prop.setProperty("serverTimezone", "Europe/Kiev");
        prop.setProperty("user", dbUser);
        prop.setProperty("password", dbPass);
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        dbConection = DriverManager.getConnection(connectionString, prop);
        return dbConection;
    }

}
