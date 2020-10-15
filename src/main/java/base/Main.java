package base;

import base.configs.MyConfig;
import base.service.article.ArticleService;
import base.service.manufacturer.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

//цей клас вже лишній
@Component
public class Main {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ManufacturerService manufacturerService;

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Main main = context.getBean(Main.class);
        main.test();
    }

    private void test() {
        System.out.println(articleService.getArticle(2).get());
        int idManufacturer = manufacturerService.getRandomManufacturersId();
        articleService.createArticle("soup",2.8, idManufacturer);
        System.out.println(articleService.getAll());
    }

}
