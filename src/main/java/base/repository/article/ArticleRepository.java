package base.repository.article;

import base.entity.Article;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;
import java.util.Set;

@ComponentScan
public interface ArticleRepository {
    Set<Article> getAll();

    Optional<Article> articleId(int id);

    int createArticle(String name, double price, int idManufacturer);
}
