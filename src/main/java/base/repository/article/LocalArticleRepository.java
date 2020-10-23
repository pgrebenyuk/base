package base.repository.article;

import base.entity.Article;
import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public abstract class LocalArticleRepository implements ArticleRepository {
    private List<Article> articles;

    public LocalArticleRepository() {
        List<Manufacturer> manufacturers = Arrays.asList(
                new Manufacturer("first"),
                new Manufacturer("друга приватна"),
                new Manufacturer("manufacturer"));

        articles = Arrays.asList(
                new Article("рис", 1.9, (manufacturers.get(1))),
                new Article("макарон", 1.4, (manufacturers.get(2))),
                new Article("рукав", 1.9, (manufacturers.get(2))));
    }

    @Override
    public List<Article> getAll() {
        return articles;
    }

    public Optional<Article> findById(int idArtical) {
        return articles.stream()
                .filter(article -> article.getId() == idArtical)
                .findFirst();
    }

    @Override
    public int createArticle(String name, double price, Manufacturer manufacturer) {
        int id = articles.stream()
                .map(Article::getId)
                .max(Integer::compare)
                .get() + 1;
        new Article(name, price, manufacturer);
        return id;
    }
}
