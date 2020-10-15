package servlets;

import base.entity.Article;
import base.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class ArticleServlet extends HttpServlet {
    private static final String PAGE = "/article.jsp";
    private static final String PAGE_ERROR = "/articleError.jsp";

    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String idString = req.getParameter("id");
            int id = Integer.parseInt(idString);
            Optional<Article> article = articleService.getArticle(id);
            if (articleService.getArticle(id).isPresent()) {
                req.setAttribute("article", article.get());
                getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher(PAGE_ERROR).forward(req, resp);
            }
        } catch (Exception e) {
            getServletContext().getRequestDispatcher(PAGE_ERROR).forward(req, resp);
        }
    }
}
