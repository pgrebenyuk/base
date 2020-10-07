package base.service;
import base.entity.Articles;
import base.entity.BaseModel;
import java.util.ArrayList;

public interface ServiceArticles {
    void getAll();
    void getById(Integer id);
}
