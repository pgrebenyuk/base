package base.service;

import base.entity.Article;
import base.repository.ArticleRepository;
import base.repository.ArticleRepositoryImpl;

import java.util.Optional;
import java.util.Set;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public int createArticle(String name, double price, int idManufactured) {
        return articleRepository.createArticle(name, price, idManufactured);
    }

    @Override
    public Optional<Article> getArticle(int id) {
        //весь цей метод має бути всього return articleRepository.getById(id);
        Article article = new Article();
        Optional<Article> articleOpt = articleRepository.getById(id);
        if (articleOpt.isPresent()) {
            article = articleOpt.get();
        }
        return Optional.of(article);
    }

    @Override
    public Set<Article> getAll() {
        return articleRepository.getAll();
    }

}
