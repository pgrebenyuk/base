package base.repository.article;

import base.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MySqlArticleRepository implements ArticleRepository {

    //де модифікатор доступу?
    @Autowired
    EntityManager em;

    @Override
    public Set<Article> getAll() {
        return new HashSet<Article>(em
                .createQuery("from Article")
                .getResultList());
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
