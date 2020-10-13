package servlets;

import base.entity.Article;
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
    private final String PAGE = "/articles.jsp";
    private ArticleService articleService = new ArticleServiceImpl(new MySqlArticleRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Set<Article> articlesAll = articleService.getAll();
        req.setAttribute("articlesAll", articlesAll);
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}