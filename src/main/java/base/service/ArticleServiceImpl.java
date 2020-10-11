package base.service;

import base.entity.Article;
import base.repository.ArticleRepositoryImpl;

import java.util.HashSet;
import java.util.Set;

public class ArticleServiceImpl implements ArticleService {

    @Override
    public int size() {
        try {
            //тут єдине, що правильне це те що тут ти використовуєш репозиторій товарів
            //саме так і має бути, він має створюватись і використовуватись в сервісі
            //а от сам метод не логічний і не допомагає створити товар
            ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
            //цю стрічку правильно писати так
            //метод ж повертає сет, то просто присвой його
            //Set<Article> articlesAll = articleServiceImpl.getAll();
            Set<Article> articlesAll = new HashSet<>(articleServiceImpl.getAll());
            //якось не логічно, що метод має повернути розмір, а ще і додає 1 чогось до нього
            return articlesAll.size() + 1;
        //от цікаво, хто тут кидає таку помилку, що ти її ловиш???
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
