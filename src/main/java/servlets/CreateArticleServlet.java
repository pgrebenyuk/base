package servlets;

import base.repository.MySqlArticleRepository;
import base.repository.MySqlManufacturerRepository;
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
public class CreateArticleServlet extends HttpServlet {
    private final String PAGE = "/newArticleCreated.jsp";
    private  ArticleService articleService = new ArticleServiceImpl(new MySqlArticleRepository());
    private ManufacturerService manufacturerService = new ManufacturerServiceImpl(new MySqlManufacturerRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceString = req.getParameter("price");
        double price = Double.parseDouble(priceString);
        int idManufactured = manufacturerService.getRandomManufacturersId();
        int id = articleService.createArticle(name, price, idManufactured);
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}
