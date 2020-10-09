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
            //ServletException не викидається
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String idString = req.getParameter("id");


        //тут ти неправильно зрозумів
        //по шляху /article?id=2 має показуватись товар з id 2
        //а от для того, щоб показало всі товари треба зробити інший сервелет по шляху наприклад /articles
        //раніше ти jsp використовував, а тепер напряму пишеш. чого? краще jsp
        try {
            ArticleDAO dao = new ArticleDAO();
            int id = Integer.parseInt(idString);
            if (id > 0) {
                Optional<Article> articleOpt = dao.getById(id);
                if (articleOpt.isPresent()) {
                    Article article = articleOpt.get();
                    writer.println("<h2>article:" + article.toString() + "</h2>");
                }
                //а коли не знайдеться такого id, то що будеш виводити?
            } else {
                Set<Article> articleAll = new HashSet();
                articleAll.addAll(dao.getAll());
                //чисто для практики
                //articleAll.stream().forEach(article -> writer.println("<h2>article:" + article.toString() + "</h2>"));
                //це те саме, що і нижче, але джава 8 і це треба знати і розуміти
                for (Article art : articleAll) {
                    writer.println("<h2>article:" + art.toString() + "</h2>");
                }
            }
        } finally {
            writer.close();
        }
    }
}
