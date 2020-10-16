package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class ArticlesServlet {
    private static final String PAGE = "articles";
    private static final String PAGE_ERROR = "articleError";

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public String doServlet(ModelMap model) {
        try {
            Set<Article> articlesAll = articleService.getAll();
            model.addAttribute("articlesAll", articlesAll);
            //що ловиш?
        } catch (Exception e) {
            return PAGE_ERROR;
        }
        return PAGE;
    }
}