import base.entity.Article;
import base.repository.article.MySqlArticleRepository;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws SQLException {
//        new ArticleDAO().insertRow(5, "ewjrgh", 1.56, 7);

        MySqlArticleRepository dao = new MySqlArticleRepository();
        Optional<Article> articleOpt = dao.articleId(2);
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
