package base.repository.article;

import base.entity.Article;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

//в спрінг є спеціальні анотації для репозиторія @Repository
//по суті це то й же компонент, але просто позначає репозиторій
@Component
public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> articleId(int id);
    int createArticle(String name, double price, int idManufacturer);
}
