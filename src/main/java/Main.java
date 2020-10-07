import base.entity.Article;
import base.service.ArticleDAO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws SQLException {
        Set<Article> articleAll = new HashSet();
        ArticleDAO dao = new ArticleDAO();
//      Запутався в Optional
//        Optional<Article> article = dao.getById(2);
//        System.out.println(article.orElse(new Article()).toString());
        articleAll.addAll(dao.getAll());
        System.out.println(articleAll);
//        for (Article article1 : articleAll) {
//            System.out.println(article.getArticle());
//        }

    }
}
