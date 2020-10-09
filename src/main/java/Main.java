import base.entity.Article;
import base.service.ArticleDAO;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws SQLException {

        ArticleDAO dao = new ArticleDAO();
        Optional<Article> articleOpt = dao.getById(2);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            System.out.println(article);
        }

        Set<Article> articleAll = new HashSet();
        articleAll.addAll(dao.getAll());
        for (Article art : articleAll) {
            System.out.println(art);
        }

    }
}
