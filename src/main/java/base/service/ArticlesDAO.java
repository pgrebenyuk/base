package base.service;

import base.DataBaseHandler;
import base.entity.Articles;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

//назва ArticleDAO
//не повинен наслідуватись від Article, бо нічого від нього не наслідує
public class ArticlesDAO extends Articles implements ServiceArticles {
    //немає модифікатора дступу, хтось може отримати доступ
    Connection connection;
    //стейтмент повинен створюватись новий на операцію, того не треба його тут, як поле
    Statement statement;


    /*
    //створювати connection можна тут
    public ArticlesDAO() {
        try {
            connection = DataBaseHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Problems with connection");
        }

    }*/

    private Articles extractUserFromResultSet(ResultSet rs) throws SQLException {
        Articles articles = new Articles();

        //назви полів можна також повиносити в константи
        articles.setId(rs.getInt("id_article"));
        articles.setArticle(rs.getString("article"));
        articles.setPrice(rs.getDouble("price"));
        articles.setManufacturer(rs.getInt("id_manufacturer"));


        return articles;
    }

    //типізувати
    @Override
    public Set getAll() {

        try {
            //тут вже його не треба буде створювати
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            //типізувати
            Set articlesAll = new HashSet();
            //створюй цю змінну там, де і використовуєш
            Articles articles;
            //винести в константу
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
    //якщо захоч то це може повертати Optional<Article>
    public Articles getById(Integer id) {
        try {
            //тут вже не треба
            connection = DataBaseHandler.getConnection();
            statement = connection.createStatement();
            //приклад стейтмента без ін*єкцій
            /*PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles WHERE id_article=?");
            statement.setInt(1, id);*/
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
