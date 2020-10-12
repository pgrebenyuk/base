package base.service;

import base.repository.ArticleRepositoryImpl;

public class ArticleServiceImpl implements ArticleService {
    @Override
    public int createArticleReturnId(String name, double price) {
        //створюй змінну через інтерфейс
        ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
        //змінна названа не по конвенціям джави
        //сервіс артікла не повинен визивати сервіс мануфактури
        //але він може визивати все, що нижче рівнем, тобто може визивати репозитрій мануфактури
        //є клас Random, а внього метод nextInt(10), тут 10 це буде верхня границя рандома (від 0 до 9)
        int IdManufacturedRandom = (int) (Math.random() * new ManufacturerServiceImpl()
                .getManufacturersCount() + 1);
        articleServiceImpl.createRow(name, price, IdManufacturedRandom);
        return articleServiceImpl.getMaxId();
    }

}
