package base.repository;
import base.entity.Article;

import java.util.Optional;
import java.util.Set;

public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> getById(int id);
    void insertRow(int id, String name, double prise, int idManufacturer);
}
