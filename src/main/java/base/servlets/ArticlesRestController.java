package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

//зроби для рест контроллерів окрему папку
//і зроби щоб 2 цих рест контроллера були в одному класі, так можна
//так як вони обою працюють з артікл, то це буде логічно
@RestController
public class ArticlesRestController {

    @Autowired
    private ArticleService articleService;

    //краще produces = MediaType.APPLICATION_JSON_VALUE
    @GetMapping(value = "/rest/articles", produces = "application/json")
    public Set<Article> doRest() {
        return articleService.getAll();
    }

}