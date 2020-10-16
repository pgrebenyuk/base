package base.repository.article;

import base.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> articleId(int id);
    int createArticle(String name, double price, int idManufacturer);
}
