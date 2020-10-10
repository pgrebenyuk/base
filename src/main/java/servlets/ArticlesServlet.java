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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            ArticleDAO dao = new ArticleDAO();
            Set<Article> articlesAll = new HashSet();
            articlesAll.addAll(dao.getAll());
            req.setAttribute("articlesAll",articlesAll );
        //тут ніхто не кидає цю помилку, ти скопіював це трай я думаю
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // /articles.jsp можна в константу
        getServletContext().getRequestDispatcher("/articles.jsp").forward(req, resp);
    }
}