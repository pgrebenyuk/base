package base.service.article;

import base.entity.Article;
import base.repository.article.ArticleRepository;
import java.util.Optional;
import java.util.Set;

public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public int createArticle(String name, double price, int idManufactured) {
        return articleRepository.createArticle(name, price, idManufactured);
    }

    @Override
    public Optional<Article> getArticle(int id) {
        return articleRepository.articleId(id);
    }

    @Override
    public Set<Article> getAll() {
        return articleRepository.getAll();
    }

}
