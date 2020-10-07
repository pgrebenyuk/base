import base.DataBaseHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = new DataBaseHandler().getDbConnection();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM articles";
            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.printf("try");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String article = resultSet.getString(2);
                Double price = resultSet.getDouble(3);
                int idManufactured = resultSet.getInt(4);

                System.out.println("id: " + id);
                System.out.println("article: " + article);
                System.out.println("price: " + price);
                System.out.println("idManufactured: " + idManufactured);
                System.out.println("===================\n");
            }
        }catch (SQLException throwable) {
            System.out.printf("catch");
            throwable.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

//        try {
//            connection = new DataBaseHandler().getDbConection();
//
//        } catch (SQLException throwable) {
//            throwable.printStackTrace();
//        }
    }
}
