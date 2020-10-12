package servlets;

import base.repository.ArticleRepositoryImpl;
import base.repository.ManufacturerRepositoryImpl;
import base.service.ArticleService;
import base.service.ArticleServiceImpl;
import base.service.ManufacturerService;
import base.service.ManufacturerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-article")
//краща назва CreateArticleServlet
public class ArticleCreatedServlet extends HttpServlet {
    //це не повинно бути статичним
    //і переназви jsp на щось типу newArticleCreated.jsp
    private static final String PAGE = "/createArticleByName&Price.jsp";
    //це не повинно бути статичним
    private static ArticleService articleService = new ArticleServiceImpl(new ArticleRepositoryImpl());
    //це не повинно бути статичним
    private static ManufacturerService manufacturerService = new ManufacturerServiceImpl(new ManufacturerRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceString = req.getParameter("price");
        double price = Double.parseDouble(priceString);
        int idManufactured = manufacturerService.getIdManufacturersRandom();
        int id = articleService.createArticle(name, price, idManufactured);
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}
