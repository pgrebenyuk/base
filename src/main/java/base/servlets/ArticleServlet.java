package base.servlets;

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
        try {
            Optional<Article> article = articleService.getArticle(id);
            if (article.isPresent()) {
                model.addAttribute("article", article.get());
            } else {
                return PAGE_ERROR;
            }
            //не розумію, яку помилку ти ловиш тепер, параметри 100 відсотків коректні будуть
        } catch (Exception e) {
            return PAGE_ERROR;
        }
        return PAGE;
    }
}
