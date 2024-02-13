package io.security.springsecuritymaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/cookie")
    public String requestCsrf(){
        return "csrf";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }

}
