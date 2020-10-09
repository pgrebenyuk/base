package base.service;

import base.DataBaseConnectionManager;
import base.entity.Article;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ArticleDAO implements ArticleService {
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_ARTICLE = "article";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM articles";
    //забув використати
    private static final String SQL_BY_ID = "SELECT * FROM articles WHERE id_article=?";

    private Connection connection;

    public ArticleDAO() {
        try {
            this.connection = DataBaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Article extractUserFromResultSet(ResultSet rs) throws SQLException {
        Article article = new Article();

        article.setId(rs.getInt(COLUMN_ID_ARTICLE));
        article.setArticle(rs.getString(COLUMN_ARTICLE));
        article.setPrice(rs.getDouble(COLUMN_PRICE));
        article.setManufacturerId(rs.getInt(COLUMN_ID_MANUFACTURER));

        return article;
    }

    @Override
    public Set<Article> getAll() {

        try {
            Statement statement = connection.createStatement();
            Set<Article> articlesAll = new HashSet();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Article article = extractUserFromResultSet(resultSet);
                articlesAll.add(article);
            }
            return articlesAll;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        //return articlesALL;
        //краще так, тоді вона повернеться або пуста, або з кількома вже записаними елементами
        // (якщо вдруг помилка сталась на 3 елементі, то 2 будуть в сеті, якщо на 1, то верне пустий сет)
        return new HashSet();
    }

    @Override
    public Optional<Article> getById(int id) {
        try {
            //використай константу
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles WHERE id_article=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(extractUserFromResultSet(resultSet));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return Optional.empty();
    }



}
