package base.repository.article;

import base.entity.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public abstract class MySqlArticleRepository implements ArticleRepository{

    @Override
    public int createArticle(String name, double price, Manufacturer manufacturer) {
        return -1;
    }

}
