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
        Set<Article> articlesAll = new HashSet();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);

            while (resultSet.next()) {
                Article article = extractUserFromResultSet(resultSet);
                articlesAll.add(article);
            }
            return articlesAll;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return articlesAll;
    }

    @Override
    public Optional<Article> getById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_BY_ID);
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