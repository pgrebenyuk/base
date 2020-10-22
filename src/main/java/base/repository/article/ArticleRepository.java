package base.repository.article;

import base.entity.Article;
import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface ArticleRepository {
    List<Article> getAll();

    Optional<Article> articleId(int id);

    int createArticle(String name, double price, Manufacturer manufacturer) throws SQLException;
}
