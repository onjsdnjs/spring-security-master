package io.security.springsecuritymaster;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @GetMapping("/loginPage")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/anonymous")
    public String anonymous(){
        return "anonymous";
    }

    @GetMapping("/authentication")
    public String authentication(Authentication authentication){

        if (authentication instanceof AnonymousAuthenticationToken) {
            return "anonymous";
        } else {
            return "null";
        }
    }
    @GetMapping("/anonymousContext")
    public String anonymousContext(@CurrentSecurityContext SecurityContext context){
        return context.getAuthentication().getName();
    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(){
        return "logoutSuccess";
    }
}
