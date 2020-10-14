package servlets;

import base.configs.MyConfig;
import base.entity.Article;
import base.service.article.ArticleService;
import base.service.article.ArticleServiceImpl;

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
    //кожен раз діставити щось з контексту і сетити буде заморочно
    //спрінг це має зробити замість тебе
    private ArticleService articleService = MyConfig
            .context
            .getBean(ArticleServiceImpl.class);

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