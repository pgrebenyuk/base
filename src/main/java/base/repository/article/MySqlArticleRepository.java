package base.repository.article;

import base.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MySqlArticleRepository implements ArticleRepository {
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_ARTICLE = "article";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";
    private static final String SQL_SELECT_ALL = "SELECT * FROM articles";
    private static final String SQL_BY_ID = "SELECT * FROM articles WHERE id_article=?";
    private static final String SQL_INSERT = "INSERT INTO articles (" + COLUMN_ARTICLE + ", "
            + COLUMN_PRICE + ", " + COLUMN_ID_MANUFACTURER + ") VALUES ( ?, ?, ?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Set<Article> getAll() {
        return new HashSet<>(jdbcTemplate.query(SQL_SELECT_ALL, new ArticleMapper()));
    }

    @Override
    public Optional<Article> articleId(int id) {
        return Optional.of(jdbcTemplate.query(SQL_BY_ID, new ArticleMapper(), id).get(0));
    }

    @Override
    public int createArticle(String name, double price, int idManufacturer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, idManufacturer);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}
