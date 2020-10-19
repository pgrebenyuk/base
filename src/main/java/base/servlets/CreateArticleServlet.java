package base.servlets;

import base.service.article.ArticleService;
import base.service.manufacturer.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateArticleServlet {
    private static final String PAGE = "newArticleCreated";

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/create-article")
    public String doServlet(@RequestParam("name") String name,
                            @RequestParam("price") double price,
                            ModelMap model) {
        int idManufactured = manufacturerService.getRandomManufacturersId();
        int id = articleService.createArticle(name, price, idManufactured);
        model.addAttribute("id", id);
        return PAGE;
    }
}
