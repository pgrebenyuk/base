package base.controller;

import base.Application;
import base.service.article.ArticleService;
import base.service.manufacturer.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateArticleServlet {
    private static final String PAGE = "newArticleCreated";
    private static final String PAGE_ERROR = "articleError";
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);


    @Autowired
    private ArticleService articleService;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/create-article")
    public String doServlet(@RequestParam("name") String name,
                            @RequestParam("price") double price,
                            ModelMap model) {
        if (manufacturerService.getRandomManufacturer().isPresent()) {
            int id = articleService.createArticle(name, price
                    , manufacturerService.getRandomManufacturer().get());
            model.addAttribute("id", id);
            return PAGE;
        } else {
            LOGGER.error("this is a error message");
            return PAGE_ERROR;
        }
    }
}
