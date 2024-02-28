package io.security.springsecuritymaster;

import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";

    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(@CurrentSecurityContext SecurityContext context){
        return "logoutSuccess";
    }
}
