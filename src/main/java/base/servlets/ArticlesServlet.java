package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping("/articles")
public class ArticlesServlet {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public void doServlet(ModelMap model) {
        try {
            Set<Article> articlesAll = articleService.getAll();
            model.addAttribute("articlesAll", articlesAll);
        } catch (Exception e) {
            int asd = 0;
        }
    }
}