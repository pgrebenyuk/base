package base.repository;

import base.DataBaseConnectionManager;
import base.entity.Article;
import base.service.ArticleServiceImpl;
import base.service.ManufacturerServiceImpl;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ArticleRepositoryImpl implements ArticleRepository {
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_ARTICLE = "article";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM articles";
    private static final String SQL_BY_ID = "SELECT * FROM articles WHERE id_article=?";
    private static final String SQL_INSERT = "INSERT INTO articles\n" +
            "  VALUES (?, ?, ?, ?);";

    private Connection connection;

    public ArticleRepositoryImpl() {
        try {
            this.connection = DataBaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Article extractUserFromResultSet(ResultSet rs) throws SQLException {
        Article article = new Article();

        article.setId(rs.getInt(COLUMN_ID_ARTICLE));
        article.setName(rs.getString(COLUMN_ARTICLE));
        article.setPrice(rs.getDouble(COLUMN_PRICE));
        article.setManufacturerId(rs.getInt(COLUMN_ID_MANUFACTURER));

        return article;
    }

    @Override
    public Set<Article> getAll() {
        Set<Article> articlesAll = new HashSet<>();

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

    @Override
    public void createArticle(int id, String name, double prise, int idManufacturer) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, prise);
            statement.setInt(4, idManufacturer);
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void createArticle(String name, double prise) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, new ArticleServiceImpl().size() + 1);
            statement.setString(2, name);
            statement.setDouble(3, prise);
            statement.setInt(4, (int) (Math.random() * new ManufacturerServiceImpl().size() + 1));
            statement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }


}
