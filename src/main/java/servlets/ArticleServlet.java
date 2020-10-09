package servlets;

import base.entity.Article;
import base.service.ArticleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String idString = req.getParameter("id");


        try {
            ArticleDAO dao = new ArticleDAO();
            int id = Integer.parseInt(idString);
            if (id > 0) {
                Optional<Article> articleOpt = dao.getById(id);
                if (articleOpt.isPresent()) {
                    Article article = articleOpt.get();
                    writer.println("<h2>article:" + article.toString() + "</h2>");
                }
            } else {
                Set<Article> articleAll = new HashSet();
                articleAll.addAll(dao.getAll());
                for (Article art : articleAll) {
                    writer.println("<h2>article:" + art.toString() + "</h2>");
                }
            }
        } finally {
            writer.close();
        }
    }
}
