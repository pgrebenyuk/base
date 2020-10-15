package servlets;

import base.configs.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitWebListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        ServletContext servletContext = servletContextEvent.getServletContext();
        ServletRegistration servletRegistrationArticles = servletContext
                .addServlet("articles", context.getBean(ArticlesServlet.class));
        servletRegistrationArticles.addMapping("/articles");
        ServletRegistration servletRegistrationArticle = servletContext
                .addServlet("article", context.getBean(ArticleServlet.class));
        servletRegistrationArticle.addMapping("/article");
        ServletRegistration servletRegistrationCreateArticle = servletContext
                .addServlet("createArticle", context.getBean(CreateArticleServlet.class));
        servletRegistrationCreateArticle.addMapping("/create-article");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
