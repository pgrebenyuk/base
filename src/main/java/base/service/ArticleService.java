package base.service;

import base.entity.Article;
import base.repository.ArticleRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

public interface ArticleService {
    static int size() {
        try {
            ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
            Set<Article> articlesAll = new HashSet<>(articleServiceImpl.getAll());
            return articlesAll.size() + 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
    static void insertRow(int id, String name, double price, int idManufacturer) {
        try {
            ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
            articleServiceImpl.insertRow(id, name, price, idManufacturer);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
