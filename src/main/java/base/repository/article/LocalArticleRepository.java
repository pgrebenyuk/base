package base.repository.article;

import base.entity.Article;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalArticleRepository implements ArticleRepository {
    private List<Article> articles;

    public LocalArticleRepository() {
        articles = Arrays.asList(
                new Article("рис", 1.9, 2),
                new Article("макарон", 1.4, 2),
                new Article("рукав", 1.9, 1)
        );
    }

    @Override
    public List<Article> getAll() {
        return articles;
    }

    @Override
    public Optional<Article> articleId(int idArtical) {
        return articles.stream()
                .filter(article -> article.getId() == idArtical)
                .findFirst();
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        int id = articles.stream()
                .map(Article::getId)
                .max(Integer::compare)
                .get() + 1;
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);
        article.setManufacturerId(idManufacturer);
        articles.add(article);

        return id;
    }
}
