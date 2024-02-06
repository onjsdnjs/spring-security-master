package io.security.springsecuritymaster;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index(String customParam){
        if(customParam == null){
            return "index";
        }else{
            return "customPage";
        }
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
    public String logoutSuccess(@CurrentSecurityContext SecurityContext context){
        return "logoutSuccess";
    }

    @GetMapping("/invalidSessionUrl")
    public String invalidSessionUrl(){
        return "invalidSessionUrl";
    }

    @GetMapping("/expired")
    public String expired(){
        return "expired";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/denied")
    public String denied(){
        return "denied";
    }

    @GetMapping("/login")
    public String customLogin(){
        return "loginPage 를 구현해야 한다";
    }

    @PostMapping("/csrf")
    public String csrf(){
        return "csrf 적용";
    }

    @PostMapping("/notCsrf")
    public String notCsrf(){
        return "csrf 적용 안함";
    }

}
