package base.repository;

import base.entity.Article;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LocalArticleRepositoryImpl implements ArticleRepository {
    private static Set<Article> articleLocal;

    public LocalArticleRepositoryImpl() {
        Article article = new Article();
        article.setId(1);
        article.setName("рис");
        article.setPrice(1.9);
        article.setManufacturerId(2);
        articleLocal.add(article);
        article.setId(2);
        article.setName("макарон");
        article.setPrice(7.2);
        article.setManufacturerId(1);
        articleLocal.add(article);
        article.setId(3);
        article.setName("рукав");
        article.setPrice(3.2);
        article.setManufacturerId(3);
        articleLocal.add(article);
    }

    @Override
    public Set<Article> getAll() {
        Set<Article> articlesAll = articleLocal;
        return articlesAll;
    }

    @Override
    public Optional<Article> getById(int idArtical) {
        return Optional.of(articleLocal.stream().filter(id -> Objects.equals(id, idArtical)).findFirst().get());
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        int id = articleLocal.stream().map(x -> x.getId()).max(Integer::compare).get() +1;
        Article article = new Article();
        article.setId(id);
        article.setName(name);
        article.setPrice(price);
        article.setManufacturerId(idManufacturer);
        articleLocal.add(article);

        return id;
    }
}
