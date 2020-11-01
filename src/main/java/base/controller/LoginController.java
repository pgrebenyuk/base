package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//цей контроллер потрібен тільки, якщо використовуєш свою логін сторінку
//якщо використовувати логін спрінга, то він все створить сам
@Controller
public class LoginController {

    @GetMapping("/login")
    //ввідступ перед дужкою
    //непотрібний параметр model, можна без нього
    public String loginPage(Model model){
        return "login";
    }

}