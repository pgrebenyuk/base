package base.repository;
import base.entity.Article;

import java.util.Optional;
import java.util.Set;

public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> getById(int id);
    void createRow(String name, double price, int idManufacturer);
}
