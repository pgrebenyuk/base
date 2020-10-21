package base.repository.article;

import base.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MySqlArticleRepository implements ArticleRepository {
//    private static final String COLUMN_ARTICLE = "article";
//    private static final String COLUMN_PRICE = "price";
//    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT c from Article c";
//    private static final String SQL_BY_ID = "SELECT * FROM articles WHERE id_article=?";
//    private static final String SQL_INSERT = "INSERT INTO articles (" + COLUMN_ARTICLE + ", "
//            + COLUMN_PRICE + ", " + COLUMN_ID_MANUFACTURER + ") VALUES ( ?, ?, ?);";

    @Autowired
    EntityManager entityManager;

    @Override
    public Set<Article> getAll() {
        return new HashSet<Article>(entityManager
                .createQuery(SQL_SELECT_ALL)
                .getResultList());
    }

    @Override
    public Optional<Article> articleId(int id) {
        return Optional.of(entityManager.find(Article.class, id));
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection
//                    .prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, name);
//            ps.setDouble(2, price);
//            ps.setInt(3, idManufacturer);
//            return ps;
//        }, keyHolder);
        return 1;
    }

}
