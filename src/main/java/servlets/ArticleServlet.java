package servlets;

import base.entity.Article;
import base.service.ArticleDAO;

import javax.servlet.RequestDispatcher;
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

        String idString = req.getParameter("id");

        try {
            ArticleDAO dao = new ArticleDAO();
            int id = Integer.parseInt(idString);
            Optional<Article> articleOpt = dao.getById(id);

            if (articleOpt.isPresent()) {
                Article article = articleOpt.get();
                //ти замість цих 4 атрибутів можеш записати всього 1 і записати в нього цей об*єкт
                //а вже в jsp виводити як ${article.id} і т.д.
                req.setAttribute("id", id);
                req.setAttribute("article", article.getArticle());
                req.setAttribute("price", article.getPrice());
                req.setAttribute("manufacturerId", article.getManufacturerId());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // /article.jsp можна в константу
        getServletContext().getRequestDispatcher("/article.jsp").forward(req, resp);
    }
}
