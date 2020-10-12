package servlets;

import base.entity.Article;
import base.repository.ArticleRepositoryImpl;

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

        ArticleRepositoryImpl dao = new ArticleRepositoryImpl();
        //по-перше знов створив new HashSet() - а це сирий тип, якщо немає <>
        //dao.getAll() поаертає Set<Article, значить можна зразу присвоїти змінній результат виконання
        //Set<Article> articlesAll = dao.getAll();
        Set<Article> articlesAll = new HashSet();
        articlesAll.addAll(dao.getAll());
        req.setAttribute("articlesAll", articlesAll);
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}