package base.repository;
import base.entity.Article;

import java.util.Optional;
import java.util.Set;

public interface ArticleRepository {
    Set<Article> getAll();
    Optional<Article> getById(int id);
    //цей метод має мати лише 3 поля, бо id створить база даних при вставці
    //ціна пишеться price, в тебе помилка
    //повертати має id створеного об*єкта
    void createArticle(int id, String name, double prise, int idManufacturer);
    //цього методу в репозиторії не повинно бути
    //такий повинен бути в сервісі і після того, як сервіс ще й взнає id виробника, то він має визвати метод вище
    void createArticle(String name, double prise);
}
