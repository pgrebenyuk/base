package base.service.article;

import base.entity.Article;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ArticleService {
    int createArticle(String name, double price, int idManufactured);
    Optional<Article> getArticle(int id);
    //зміни всюди, щоб був List, а не Set
    //нам тут особливості сета не пригодяться
    Set<Article> getAll();
}
