package servlets;

import base.configs.MyConfig;
import base.repository.article.LocalArticleRepository;
import base.repository.manufacturer.LocalManufacturerRepository;
import base.service.article.ArticleService;
import base.service.article.ArticleServiceImpl;
import base.service.manufacturer.ManufacturerService;
import base.service.manufacturer.ManufacturerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-article")
public class CreateArticleServlet extends HttpServlet {
    private static final String PAGE = "/newArticleCreated.jsp";
    private static final String PAGE_ERROR = "/articleError.jsp";
    private ArticleService articleService = MyConfig
            .context
            .getBean(ArticleServiceImpl.class);
    private ManufacturerService manufacturerService = MyConfig
            .context
            .getBean(ManufacturerServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String priceString = req.getParameter("price");
            double price = Double.parseDouble(priceString);
            int idManufactured = manufacturerService.getRandomManufacturersId();
            int id = articleService.createArticle(name, price, idManufactured);
            req.setAttribute("id", id);
            getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher(PAGE_ERROR).forward(req, resp);
        }

    }
}
