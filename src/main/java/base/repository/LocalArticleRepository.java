package base.repository;

import base.entity.Article;

import java.util.*;

public class LocalArticleRepository implements ArticleRepository {
    private static Set<Article> articles;

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
        return articles.stream().filter(article -> article.getId() == idArtical).findFirst();
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        int id = articles.stream().map(x -> x.getId()).max(Integer::compare).get() + 1;
        Article article = new Article();
        article.setId(id);
        article.setName(name);
        article.setPrice(price);
        article.setManufacturerId(idManufacturer);
        articles.add(article);

        return id;
    }
}