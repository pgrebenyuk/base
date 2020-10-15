package base.servlets;

import base.service.article.ArticleService;
import base.service.manufacturer.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/created-article")
public class CreateArticleServlet extends HttpServlet {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(method = RequestMethod.GET)
    public void doServlet(ModelMap model) {
        try {
            String name = (String) model.getAttribute("name");
            double price = (Double) model.getAttribute("price");
            int idManufactured = manufacturerService.getRandomManufacturersId();
            int id = articleService.createArticle(name, price, idManufactured);
            model.addAttribute("id", id);
        } catch (Exception e) {
            int asd = 0;
        }
    }
}
