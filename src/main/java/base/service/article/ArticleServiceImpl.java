package base.service.article;

import base.entity.Article;
import base.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

//в спрінг є спеціальні анотації для сервіса @Service
//по суті це то й же компонент, але просто позначає сервіс
@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    @Qualifier("localArticleRepository")
    private ArticleRepository articleRepository;

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
