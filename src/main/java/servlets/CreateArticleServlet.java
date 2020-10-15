package servlets;

import base.service.article.ArticleService;
import base.service.manufacturer.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CreateArticleServlet extends HttpServlet {
    private static final String PAGE = "/newArticleCreated.jsp";
    private static final String PAGE_ERROR = "/articleError.jsp";

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ManufacturerService manufacturerService;

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
