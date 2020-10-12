package base.repository;

import base.entity.Article;

import java.util.*;

//переназви LocalArticleRepository
public class LocalArticleRepositoryImpl implements ArticleRepository {
    //краща назва articles
    private static Set<Article> articleLocal;

    public LocalArticleRepositoryImpl() {
        /*
        //отак можна швидко створювати лісти і сети
        //але для цього тобі прийдеться додати в Article конструктор зі всіма параметрами
        //зато виглядить круто
        articleLocal = new HashSet<>(Arrays.asList(
                new Article(1, "рис", 1.9, 2),
                new Article(2, "рс", 1.4, 2),
                new Article(3, "ис", 1.9, 3)
        ));*/
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
        //просто return articleLocal
        Set<Article> articlesAll = articleLocal;
        return articlesAll;
    }

    @Override
    //помилка в назві
    //правильно буде articleId
    public Optional<Article> getById(int idArtical) {
        //findFirst() вже сам повертає Optional, того не треба брати з нього результат і запаковувати
        //return articleLocal.stream().filter(id -> Objects.equals(id, idArtical)).findFirst();
        return Optional.of(articleLocal.stream().filter(id -> Objects.equals(id, idArtical)).findFirst().get());
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        //норм стрім написав
        //відступ перед + додай
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
