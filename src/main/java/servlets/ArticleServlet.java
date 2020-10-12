package servlets;

import base.entity.Article;
import base.repository.ArticleRepositoryImpl;
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
    //це не повинно бути статичним
    private static final String PAGE = "/article.jsp";
    //це не повинно бути статичним
    private static ArticleService articleService = new ArticleServiceImpl(new ArticleRepositoryImpl());

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
