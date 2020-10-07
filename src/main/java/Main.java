import base.DataBaseHandler;
import base.service.ArticlesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) throws SQLException {
//        Connection connection = null;
//        Statement statement = null;
//        new ArticlesDAO().getById(2);
        new ArticlesDAO().getAll();
        new ArticlesDAO().getById(2);

    }
}
