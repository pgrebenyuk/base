package base.service;

import base.DataBaseConnectionManager;
import base.entity.Article;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//що це за <connection>? воно тобі не потрібне
public class ArticleDAO<connection> implements ArticleService {
    //краща назва COLUMN_ID_ARTICLE
    //всі інші колонки так само
    static private final String ID_ARTICLE = "id_article";
    //спочатку модифікатор потім статік потім final, подивись в DataBaseConnectionManager
    //private static final
    static private final String ARTICLE = "article";
    static private final String PRICE = "price";
    static private final String ID_MANUFACTURER = "id_manufacturer";
    //краща назва SQL_SELECT_ALL
    static private final String SQL = "SELECT * FROM articles";

    private Connection connection;


    //це має бути конструктор, щоб при створенні об*єкта ArticleDAO ініціалізувалась ця змінна
    //переправ на конструктор
    {
        try {
            connection = DataBaseConnectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Article extractUserFromResultSet(ResultSet rs) throws SQLException {
        Article article = new Article();

        article.setId(rs.getInt(ID_ARTICLE));
        article.setArticle(rs.getString(ARTICLE));
        article.setPrice(rs.getDouble(PRICE));
        article.setManufacturerId(rs.getInt(ID_MANUFACTURER));

        return article;
    }

    @Override
    public Set<Article> getAll() {

        try {
            Statement statement = connection.createStatement();
            Set<Article> articlesAll = new HashSet();
            //створив раніше, ніж використовуєш
            Article article;
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                article = extractUserFromResultSet(resultSet);
                articlesAll.add(article);
            }
            return articlesAll;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        //не повертай null, поверни пустий set
        return null;
    }

    @Override
    public Optional<Article> getById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM articles WHERE id_article=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                return Optional.of(extractUserFromResultSet(resultSet));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        //якщ нічого немає то вертай Optional.empty()
        return Optional.of(new Article());
    }

}
