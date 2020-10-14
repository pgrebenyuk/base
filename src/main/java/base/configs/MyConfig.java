package base.configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    public static final ApplicationContext context =
            new AnnotationConfigApplicationContext("base");

}
