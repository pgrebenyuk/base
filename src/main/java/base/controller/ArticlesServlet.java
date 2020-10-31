package base.controller;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticlesServlet {
    private static final String PAGE = "articles";

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    @PostMapping("/articles")
    public String doServlet(ModelMap model) {
        List<Article> articlesAll = articleService.getAll();
        model.addAttribute("articlesAll", articlesAll);
        return PAGE;
    }
}