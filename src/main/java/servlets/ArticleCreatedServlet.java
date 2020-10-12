package servlets;

import base.service.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-article")
public class ArticleCreatedServlet extends HttpServlet {
    private static final String PAGE = "/createArticleByName&Price.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceString = req.getParameter("price");
        double price = Double.parseDouble(priceString);
        //правильно створювати змінну отак
        //ArticleService articleService = new ArticleServiceImpl();
        //так ти працюєш через інтерфейс і якщо зміниш реалізацію, то код не зламається
        ArticleServiceImpl articleServiceImpl = new ArticleServiceImpl();
        int id = articleServiceImpl.createArticleReturnId(name, price);
        req.setAttribute("id", id);
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}
