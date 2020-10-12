package servlets;

import base.service.ArticleService;
import base.service.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    private static final String PAGE = "/article.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        ArticleService articleService = new ArticleServiceImpl();
        req.setAttribute("article", articleService.getArticle(id));
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}
