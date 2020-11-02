package base.controller;

import base.Application;
import base.entity.Article;
import base.service.article.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ArticleServlet {
    private static final String PAGE = "article";
    private static final String PAGE_ERROR = "articleError";
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public String doServlet(@RequestParam("id") int id, ModelMap model) {
        Optional<Article> article = articleService.getArticle(id);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
            return PAGE;
        } else {
            LOGGER.error("this is a error message");
            return PAGE_ERROR;
        }
    }
}
