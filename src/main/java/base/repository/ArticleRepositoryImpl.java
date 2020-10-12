package base.repository;

import base.DataBaseConnectionManager;
import base.entity.Article;

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

    //цей метод не потрібний, якщо база сама буде створювати id
    public int getMaxId() {
        Set<Article> articlesAll = new ArticleRepositoryImpl().getAll();
        return articlesAll.stream().map(Article::getId).max(Integer::compare).get();
    }

    @Override
    public void createRow(String name, double price, int idManufacturer) {
        //я ж тобі перед цим писав, що id створить сама база даних,
        // якщо в ній виставити галочку автоінкремент на це поле
        //і тоді тобі не прийдеться викликати цю стрічку нижче
        //+ ти в класі ArticleRepositoryImpl створюєш нову змінну ArticleRepositoryImpl і викликаєш її метод
        //а міг би просто викликати метод int newId = new getMaxId() + 1;
        int newId = new ArticleRepositoryImpl().getMaxId() + 1;
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, newId);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.setInt(4, idManufacturer);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
