package base.service.article;

import base.entity.Article;
import base.repository.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    @Qualifier("localArticleRepository")
    private ArticleRepository articleRepository;

    @Override
    public int createArticle(String name, double price, int idManufactured) {
        try {
            return articleRepository.createArticle(name, price, idManufactured);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
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
