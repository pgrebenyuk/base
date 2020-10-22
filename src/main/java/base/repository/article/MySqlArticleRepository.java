package base.repository.article;

import base.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class MySqlArticleRepository implements ArticleRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Article> getAll() {
        return em.createQuery("from Article")
                .getResultList();
    }

    @Override
    public Optional<Article> articleId(int id) {
        return Optional.of(em.find(Article.class, id));
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        Article article = new Article(name, price, idManufacturer);
        em.persist(article);
        em.flush();
        return article.getId();
    }

}
