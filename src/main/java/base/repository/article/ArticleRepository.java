package base.repository.article;

import base.entity.Article;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

@Service
public interface ArticleRepository {

    //зміни всюди, щоб був List, а не Set
    //нам тут особливості сета не пригодяться
    Set<Article> getAll();

    Optional<Article> articleId(int id);

    int createArticle(String name, double price, int idManufacturer) throws SQLException;
}
