package servlets;

import base.entity.Article;
import base.service.ArticleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    private static final String PAGE = "/article.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idString = req.getParameter("id");

        try {
            ArticleDAO dao = new ArticleDAO();
            int id = Integer.parseInt(idString);
            Optional<Article> articleOpt = dao.getById(id);

            if (articleOpt.isPresent()) {
                Article article = articleOpt.get();
                req.setAttribute("article", article);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher(PAGE).forward(req, resp);
    }
}
