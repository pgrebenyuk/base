package base.service;

import base.entity.Article;

import java.util.Set;

public interface ArticleService {
    int createArticle(String name, double price, int idManufactured);
    Article getArticle(int id);
    Set<Article> getAll();
}
