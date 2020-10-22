package base.repository.article;

import base.entity.Article;
import base.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    public int createArticle(String name, double price, Manufacturer manufacturer) {
        EntityTransaction userTransaction = em.getTransaction();
        userTransaction.begin();
        Article article = new Article(name, price, manufacturer);
        em.persist(article);
        em.flush();
        userTransaction.commit();

        return article.getId();
    }

}
