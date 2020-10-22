package base.service.article;

import base.entity.Article;
import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArticleService {
    int createArticle(String name, double price, Manufacturer manufacturer);
    Optional<Article> getArticle(int id);
    List<Article> getAll();
}
