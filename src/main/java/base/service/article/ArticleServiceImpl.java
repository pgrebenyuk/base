package base.service.article;

import base.configs.MyConfig;
import base.entity.Article;
import base.repository.article.ArticleRepository;
import base.repository.article.LocalArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    @Qualifier("localArticleRepository")
    private ArticleRepository articleRepository;

    public ArticleServiceImpl() {
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
