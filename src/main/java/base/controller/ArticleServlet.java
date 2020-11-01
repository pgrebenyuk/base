package base.controller;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ArticleServlet {
    private static final String PAGE = "article";
    private static final String PAGE_ERROR = "articleError";

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public String doServlet(@RequestParam("id") int id, ModelMap model) {
        Optional<Article> article = articleService.getArticle(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return PAGE;
        } else {
            return PAGE_ERROR;
        }
    }
}
