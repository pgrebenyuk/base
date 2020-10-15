package base.servlets;

import base.configs.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import servlets.ArticlesServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;


//це новий клас, йоо задача зробити щось перед тим, як створяться сервлети
// і тут я хочу показати, як я підміню 1 сервлет
// я заставлю сервлет апі не самому створити сервлет, а використати мій об*єкт
// і тут же я і зроблю контекст спрінга
@WebListener
public class InitWebListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //дістаю сервлет з спрінга
        ArticlesServlet articlesServlet = context.getBean(ArticlesServlet.class);

        ServletContext servletContext = servletContextEvent.getServletContext();
        //реєструю цей сервлет
        ServletRegistration servletRegistration = servletContext.addServlet("articles", articlesServlet);
        servletRegistration.addMapping("/articles");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
