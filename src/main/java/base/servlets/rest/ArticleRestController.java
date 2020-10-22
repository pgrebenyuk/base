package base.servlets.rest;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/rest/article", produces = MediaType.APPLICATION_JSON_VALUE)
    public Article doRest(@RequestParam int id) {
        return articleService.getArticle(id).orElse(new Article("error", 0, 0));
    }

    @GetMapping(value = "/rest/articles", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Article> doRest() {
        return articleService.getAll();
    }

}
