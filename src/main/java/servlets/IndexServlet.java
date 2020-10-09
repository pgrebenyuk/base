package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//скажу тобі, що в цьому сервлеті немає сенсу, так як по замовчуванні відкриється рут / твоєї програми
//і він відкриє index файл, тобто цей код не буде виконуватись і якщо ти його видалиш, то функціонал програми буде такий же
@WebServlet("/base_war")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
