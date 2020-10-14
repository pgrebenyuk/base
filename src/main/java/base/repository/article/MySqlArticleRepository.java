package base.repository.article;

import base.DataBaseConnectionManager;
import base.configs.MyConfig;
import base.entity.Article;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class MySqlArticleRepository implements ArticleRepository {
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_ARTICLE = "article";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM articles";
    private static final String SQL_BY_ID = "SELECT * FROM articles WHERE id_article=?";
    private static final String SQL_INSERT = "INSERT INTO articles (" + COLUMN_ARTICLE + ", "
            + COLUMN_PRICE + ", " + COLUMN_ID_MANUFACTURER + ") VALUES ( ?, ?, ?);";

    private Connection connection;

    public MySqlArticleRepository() {
        try {
            this.connection = DataBaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Article extractUserFromResultSet(ResultSet rs) throws SQLException {
        Article article = MyConfig.context.getBean(Article.class);

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
    public Optional<Article> articleId(int id) {
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
    public int createArticle(String name, double price, int idManufacturer) {
        int newId = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, idManufacturer);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                newId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newId;
    }

}
