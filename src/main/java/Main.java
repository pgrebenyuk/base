import base.DataBaseHandler;
import base.entity.Articles;
import base.service.ArticlesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws SQLException {
        //змінна далеко від використання
        Articles articles;
        Set<Articles> articlesAll = new HashSet();

        /*//приклад створення дао, далі використовуєш цей об*єкт
        ArticlesDAO dao = new ArticlesDAO();*/

        articles = new ArticlesDAO().getById(2);
        System.out.println(articles.getId());
        articlesAll.addAll(new ArticlesDAO().getAll());
        System.out.println(articlesAll);
        for (Articles articles1 : articlesAll) {
            System.out.println(articles.getArticle());
        }

    }
}
