package base.service.article;

import base.configs.MyConfig;
import base.entity.Article;
import base.repository.article.ArticleRepository;
import base.repository.article.LocalArticleRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository = MyConfig
        .context
        .getBean(LocalArticleRepository.class);

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
