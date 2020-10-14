package servlets;

import base.configs.MyConfig;
import base.entity.Article;
import base.repository.article.LocalArticleRepository;
import base.service.article.ArticleService;
import base.service.article.ArticleServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
    private static final String PAGE_ERROR = "/articleError.jsp";
    private ArticleService articleService = MyConfig
            .context
            .getBean(ArticleServiceImpl.class);

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
