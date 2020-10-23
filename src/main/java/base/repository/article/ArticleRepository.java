package base.repository.article;

import base.entity.Article;
import base.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> getAll();

    int createArticle(String name, double price, Manufacturer manufacturer);
}
