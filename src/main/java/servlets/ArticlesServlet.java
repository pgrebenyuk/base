package servlets;

import base.entity.Article;
import base.repository.LocalArticleRepository;
import base.repository.MySqlArticleRepository;
import base.service.ArticleService;
import base.service.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/articles")
public class ArticlesServlet extends HttpServlet {
    private static final String PAGE = "/articles.jsp";
    private static final String PAGE_ERROR = "/articleError.jsp";
    private ArticleService articleService = new ArticleServiceImpl(new LocalArticleRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Set<Article> articlesAll = articleService.getAll();
            req.setAttribute("articlesAll", articlesAll);
            getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
        } catch (Exception e) {
            getServletContext().getRequestDispatcher(PAGE_ERROR).forward(req, resp);
        }
    }
}