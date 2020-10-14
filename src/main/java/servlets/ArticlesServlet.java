package servlets;

//видали
import base.configs.MyConfig;
import base.entity.Article;
import base.service.article.ArticleService;
import base.service.article.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

//@WebServlet прийдеться закомітити, бо інакше цей сервлет зареєструється,
// а ми хочем самі його зареєєструвати
//@WebServlet("/articles")

//щоб спрінг заіжектив сервіс
@Component
public class ArticlesServlet extends HttpServlet {
    private static final String PAGE = "/articles.jsp";
    private static final String PAGE_ERROR = "/articleError.jsp";

    //тепер спрінг мені дасть цей сервіс
    @Autowired
    private ArticleService articleService;

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