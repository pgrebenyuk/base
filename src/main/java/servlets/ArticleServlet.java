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

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    private final String PAGE = "/article.jsp";
    private ArticleService articleService = new ArticleServiceImpl(new MySqlArticleRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        try {
            Article article = articleService.getArticle(id).get();
            req.setAttribute("article", article);
            getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
