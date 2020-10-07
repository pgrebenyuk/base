package base.service;
import base.entity.Articles;

import java.util.Set;

//назва краще ArticleService
public interface ServiceArticles {
    //треба типізувати Set<Article>
    Set getAll();
    //по бажанню можна зробити щоб повертало Optional<Article>
    //Integer id краще поміняти на примітив int id
    Articles getById(Integer id);
}
