import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    private static Connection con;

    public static void main(String[] args) {
        try {
            con = new DataBaseHandler().getDbConection();
            System.out.println("connection successful");
        } catch (SQLException throwables) {
            System.out.println("connection is not success");
            throwables.printStackTrace();
        }
    }
}
