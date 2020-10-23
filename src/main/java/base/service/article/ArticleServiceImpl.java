package base.service.article;

import base.entity.Article;
import base.entity.Manufacturer;
import base.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public int createArticle(String name, double price, Manufacturer manufacturer) {
        Article article = new Article(name, price, manufacturer);
        return articleRepository.saveAndFlush(new Article(name, price, manufacturer)).getId();
    }

    @Override
    public Optional<Article> getArticle(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

}
