package base.service;

import base.repository.ArticleRepositoryImpl;

public class ArticleServiceImpl implements ArticleService {
    @Override
    public int createArticleReturnId(String name, double price) {
        ArticleRepositoryImpl articleServiceImpl = new ArticleRepositoryImpl();
        int IdManufacturedRandom = (int) (Math.random() * new ManufacturerServiceImpl()
                .getManufacturersCount() + 1);
        articleServiceImpl.createRow(name, price, IdManufacturedRandom);
        return articleServiceImpl.getMaxId();
    }

}
