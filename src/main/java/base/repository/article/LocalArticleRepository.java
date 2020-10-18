package base.repository.article;

import base.entity.Article;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocalArticleRepository implements ArticleRepository {
    private Set<Article> articles;

    public LocalArticleRepository() {
        articles = new HashSet<>(Arrays.asList(
                new Article(1, "рис", 1.9, 2),
                new Article(2, "макарон", 1.4, 2),
                new Article(3, "рукав", 1.9, 1)
        ));
    }

    @Override
    public Set<Article> getAll() {
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
        article.setId(id);
        article.setName(name);
        article.setPrice(price);
        article.setManufacturerId(idManufacturer);
        articles.add(article);

        return id;
    }
}
