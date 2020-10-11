package servlets;

import base.repository.ArticleRepositoryImpl;
import base.service.ArticleService;
import base.service.ArticleServiceImpl;
import base.service.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-article")
public class ArticleCreatedServlet extends HttpServlet {
    private static final String PAGE = "/article?id=";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceString = req.getParameter("price");
        double price = Double.parseDouble(priceString);
        new ArticleRepositoryImpl().createArticle(name, price);
        int id = new ArticleServiceImpl().size();

        getServletContext().getRequestDispatcher(PAGE + id).forward(req, resp);
    }
}
