package base.service.article;

import base.entity.Article;
import org.springframework.context.annotation.ComponentScan;

import java.util.Optional;
import java.util.Set;

@ComponentScan
public interface ArticleService {
    int createArticle(String name, double price, int idManufactured);
    Optional<Article> getArticle(int id);
    Set<Article> getAll();
}
