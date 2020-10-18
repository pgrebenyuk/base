package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/rest/article", produces = "application/json")
    public Article doRest(@RequestParam Integer id) {
        if (articleService.getArticle(id).isPresent()) {
            return articleService.getArticle(id).get();
        } else {
            return new Article(0, "error", 0, 0);
        }
    }

}
