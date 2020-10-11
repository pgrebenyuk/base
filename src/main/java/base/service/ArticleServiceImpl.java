package base.service;

import base.entity.Article;
import base.repository.ArticleRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public int size() {
        try {
            ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
            Set<Article> articlesAll = new HashSet<>(articleServiceImpl.getAll());
            return articlesAll.size() + 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
