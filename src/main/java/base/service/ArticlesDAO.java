package base.service;

import base.DataBaseHandler;
import base.entity.Articles;
import base.entity.BaseModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticlesDAO extends Articles implements ServiceArticles {
    Connection connection;
    Statement statement;

    private Articles extractUserFromResultSet(ResultSet rs) throws SQLException {
        Articles articles = new Articles();
        articles.setId(rs.getInt("id"));
        articles.setArticle(rs.getString("article"));
        articles.setPrice(rs.getDouble("price"));
        articles.setManufacturer(rs.getInt("id_manufacturer"));
        return articles;
    }

    @Override
    public void getAll() {
        try {
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM articles";
            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.println("try");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String article = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int idManufactured = resultSet.getInt(4);

            }
        }catch (SQLException throwable) {
            System.out.println("catch");
            throwable.printStackTrace();
        }
    }

    @Override
    public void getById(Integer id) {
        try {
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM articles WHERE id_article=" + id;
            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.println("try");

            while (resultSet.next()) {
                id = resultSet.getInt(1);
                String article = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int idManufactured = resultSet.getInt(4);

                System.out.println("id: " + id);
                System.out.println("article: " + article);
                System.out.println("price: " + price);
                System.out.println("idManufactured: " + idManufactured);
                System.out.println("===================\n");
            }
        } catch (SQLException throwable) {
            System.out.println("catch");
            throwable.printStackTrace();
        }
    }

}
