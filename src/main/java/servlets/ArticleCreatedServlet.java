package servlets;

import base.repository.ArticleRepositoryImpl;
import base.service.ArticleService;
import base.service.ArticleServiceImpl;
import base.service.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-article")
public class ArticleCreatedServlet extends HttpServlet {
    private static final String PAGE = "/article?id=";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceString = req.getParameter("price");
        double price = Double.parseDouble(priceString);

        //репозиторій не створюється і не викликається в контроллері
        //для цього ми і створюємо сервіс
        //а вже сервіс в свому коді буде викликати репозиторій
        new ArticleRepositoryImpl().createArticle(name, price);
        //в сервіса має бути метод createArticle(name, price), який повертає id нового створеного товара
        //його і треба тут викликати і передати в нього параметри
        int id = new ArticleServiceImpl().size();

        //в кінці роботи сервлет має показати на вюшці id нового юзера
        //а ти зараз передаєш запит на сервлет
        getServletContext().getRequestDispatcher(PAGE + id).forward(req, resp);
    }
}
