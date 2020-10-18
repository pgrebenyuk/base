package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    //краще produces = MediaType.APPLICATION_JSON_VALUE
    @GetMapping(value = "/rest/article", produces = "application/json")
    //а просто з int працює?
    public Article doRest(@RequestParam Integer id) {
        //ти тут по суті двічі заставляєш сервіс відпрацювати, а треба раз
        //а можна всього одну стрічку замість всіх цих
        //return articleService.getArticle(id).orElse(new Article(0, "error", 0, 0));
        if (articleService.getArticle(id).isPresent()) {
            return articleService.getArticle(id).get();
        } else {
            return new Article(0, "error", 0, 0);
        }
    }

}
