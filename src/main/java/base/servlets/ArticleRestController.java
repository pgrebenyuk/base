package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController/*("/rest/article")*/
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

//не ловить    @GetMapping(value = "/rest/article/{id}")
    @GetMapping(value = "/rest/article", produces = "application/json")
    public String doRest(Integer id) {
        id = (id == null) ? 0 : id;
        if (articleService.getArticle(id).isPresent()) {
            return articleService.getArticle(id).get().toString();
        } else {
//            заглушка
            return new Article(0, "error", 0, 0).toString();
        }
    }

//    @GetMapping(value = "/rest/article", produces = "application/json")
//    public Article doRest(Integer id) {
//        id = (id == null) ? 0 : id;
//        if (articleService.getArticle(id).isPresent()) {
//            return articleService.getArticle(id).get();
//        } else {
//            return new Article(0, "error", 0, 0);
//        }
//    }
}
