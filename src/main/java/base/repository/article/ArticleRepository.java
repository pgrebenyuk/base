package base.repository.article; //між пакетом і імпортами відступ
import base.entity.Article;

import java.util.Optional;
import java.util.Set;

//ти в ManufacturerRepository додава анотацію компонент, то вже і сюди додай
public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> articleId(int id);
    int createArticle(String name, double price, int idManufacturer);
}
