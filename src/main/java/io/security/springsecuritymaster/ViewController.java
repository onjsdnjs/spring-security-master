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

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/link")
    public String link(){
        return "link";
    }

    @GetMapping("/cross")
    public String cross(){
        return "cross";
    }

}
