package base.service.article;

import base.entity.Article;
import base.entity.Manufacturer;
import base.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    @Qualifier("mySqlArticleRepository")
    private ArticleRepository articleRepository;

    @Override
    public int createArticle(String name, double price, Manufacturer manufacturer) {
        if (articleRepository.createArticle(name, price, manufacturer) == -1) {
            Article article = new Article(name, price, manufacturer);
            articleRepository.saveAndFlush(new Article(name, price, manufacturer));
            return article.getId();
        }
        return articleRepository.createArticle(name, price, manufacturer);
    }

    @Override
    public Optional<Article> getArticle(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.getAll();
    }

}
