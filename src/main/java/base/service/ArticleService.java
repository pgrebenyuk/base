package base.service;

public interface ArticleService {
    //не треба пояснювати в назві методу, що ти повернеш
    //createArticle буде краще
    int createArticleReturnId(String name, double price);
}
