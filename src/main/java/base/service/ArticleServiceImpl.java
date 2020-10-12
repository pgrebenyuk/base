package base.service;

import base.entity.Article;
import base.repository.ArticleRepository;
import base.repository.ArticleRepositoryImpl;

import java.util.Optional;
import java.util.Set;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl() {
        this.articleRepository = new ArticleRepositoryImpl();
    }

    @Override
    public int createArticle(String name, double price, int idManufactured) {
        return articleRepository.createArticle(name, price, idManufactured);
    }

    @Override
    public Article getArticle(int id) {
        Article article = new Article();
        try {
            Optional<Article> articleOpt = articleRepository.getById(id);
            if (articleOpt.isPresent()) {
                article = articleOpt.get();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Set<Article> getAll() {
        return articleRepository.getAll();
    }

}
