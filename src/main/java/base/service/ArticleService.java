package base.service;
import base.entity.Article;

import java.util.Optional;
import java.util.Set;

public interface ArticleService {
    Set<Article> getAll();
    Optional<Article> getById(int id);
}
