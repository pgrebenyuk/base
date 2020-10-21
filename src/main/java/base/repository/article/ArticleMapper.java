package base.repository.article;

import base.entity.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper implements RowMapper<Article> {
    private static final String COLUMN_ID_ARTICLE = "id_article";
    private static final String COLUMN_ARTICLE = "article";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ID_MANUFACTURER = "id_manufacturer";

    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        article.setId(rs.getInt(COLUMN_ID_ARTICLE));
        article.setName(rs.getString(COLUMN_ARTICLE));
        article.setPrice(rs.getDouble(COLUMN_PRICE));
        article.setManufacturerId(rs.getInt(COLUMN_ID_MANUFACTURER));
        return article;
    }
}
