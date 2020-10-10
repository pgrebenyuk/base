package servlets;

import base.entity.Article;
import base.service.ArticleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {
    private static final String PAGE = "/articles.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ArticleDAO dao = new ArticleDAO();
        Set<Article> articlesAll = new HashSet();
        articlesAll.addAll(dao.getAll());
        //відступ між параметрами
        req.setAttribute("articlesAll",articlesAll );
        //PAGE не використав
        getServletContext().getRequestDispatcher("/articles.jsp").forward(req, resp);
    }
}