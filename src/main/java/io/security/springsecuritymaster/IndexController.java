package io.security.springsecuritymaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/loginPage")
    public String login(){
        return "loginPage";
    }
}
