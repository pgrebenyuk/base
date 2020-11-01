package base.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//якщо закоментиш цю анотацію, то спрінг не побачить її
//і тоді він загрузить свій логін по замовуванні
//створиться всього 1 юзер user, а його пароль напишеться в консолі під час стартапу програми
//логін буде по будь-якому url, а /logout щоб вилогінитись
//спробуй це обов*язково, там дизайн прикольніший, ніж твій)
@Configuration
//спрінг бут сам її ставить, якщо б був голий спрінг, то треба б була
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //не треба такого відступа, має бути без розриву
        /*http
            .clone()*/
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/articles").permitAll()
                .antMatchers("/article", "rest/article**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").hasAnyRole( "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                //цю штуку можна налаштовувати як на сервлет, як зараз, так і на jsp наприклад, тоді сервлета не треба
                //саме тут ти кажеш спрінгу, що не хочеш використовувати його гарні сторінки для логіну
                //якщо закоментиш, то побач, що буде використовуватись сторінка спрінга, спробуй
                //а тепер можна довести до кінця і твій .jsp
                //там ти з тегами трохи наплутав, подивись коменти
                .loginPage("/login")
                .defaultSuccessUrl("/articles", true)
                //якщо використовувати твою сторінку логіна, то це потрібно, якщо спрінга - то ні
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //відступ
        auth
                .inMemoryAuthentication()
                .withUser("root")
                .password(passwordEncoder().encode("root")).roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN");
    }
}