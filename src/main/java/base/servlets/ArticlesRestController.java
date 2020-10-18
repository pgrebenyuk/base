package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ArticlesRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/rest/articles", produces = "application/json")
    public Set<Article> doRest() {
        return articleService.getAll();
    }

}