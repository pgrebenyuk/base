package base.service;
import base.entity.Articles;

import java.util.Set;

public interface ServiceArticles {
    Set getAll();
    Articles getById(Integer id);
}
