package base.service;

import base.DataBaseHandler;
import base.entity.Articles;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class ArticlesDAO extends Articles implements ServiceArticles {
    Connection connection;
    Statement statement;

    private Articles extractUserFromResultSet(ResultSet rs) throws SQLException {
        Articles articles = new Articles();

        articles.setId(rs.getInt("id_article"));
        articles.setArticle(rs.getString("article"));
        articles.setPrice(rs.getDouble("price"));
        articles.setManufacturer(rs.getInt("id_manufacturer"));


        return articles;
    }

    @Override
    public Set getAll() {

        try {
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            Set articlesAll = new HashSet();
            Articles articles;
            String SQL = "SELECT * FROM articles";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                articles = extractUserFromResultSet(resultSet);
                articlesAll.add(articles);
            }
            return articlesAll;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public Articles getById(Integer id) {
        try {
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            String SQL = "SELECT * FROM articles WHERE id_article=" + id;
            ResultSet resultSet = statement.executeQuery(SQL);

            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
