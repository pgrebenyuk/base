package base.servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

//можна прям так, буде швидше
//@Controller("/article")
//тоді @RequestMapping не треба
@Controller
@RequestMapping("/article")
public class ArticleServlet {

    @Autowired
    private ArticleService articleService;

    //можна так @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public void doServlet(ModelMap model) {
        //тут метод не дописаний
        try {
            int id = (Integer) model.getAttribute("id");
            Optional<Article> article = articleService.getArticle(id);
            if (articleService.getArticle(id).isPresent()) {
                model.addAttribute("article", article.get());
            } else {

            }
        } catch (Exception e) {
            int asd = 0;
        }

    }

}
