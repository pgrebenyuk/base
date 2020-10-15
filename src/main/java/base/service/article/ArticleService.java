package base.service.article;

import base.entity.Article;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

//в спрінг є спеціальні анотації для сервіса @Service
//по суті це то й же компонент, але просто позначає сервіс
@Component
public interface ArticleService {
    int createArticle(String name, double price, int idManufactured);
    Optional<Article> getArticle(int id);
    Set<Article> getAll();
}
