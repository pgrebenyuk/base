package base.configs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//це клас конфігурації, тут можна задати певні біни
//а також задати спрінгу, де йому шукати компоненти, які треба запхати в контекст
// і яким можливо треба заінжектити залежності
@Configuration
//так можна вказати де шукати
//@ComponentScan("base")
public class MyConfig {

    //в цьому класі можуть занходитись методи, які створюють певні біни, або ж він може бути пустим

    //new AnnotationConfigApplicationContext(MyConfig.class)
    //ця стрічка запускає спрінг прочесувати твій шлях і шукати всі біни,
    // ініціалізувати їх і записувати собі в контекст, де їх потім можна витягнути
    //і ГОЛОВНЕ вона повинна викликатись до того, як ти будеш використовувати хоч якийсь клас з залежностями
    //для тесту ти можеш погратись з класом Main і спробувати там створити контекст і дістати щось з нього
    public static final ApplicationContext context =
            new AnnotationConfigApplicationContext("base");

}
