package io.security.springsecuritymaster;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

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

    @PostMapping("/ignoreCsrf")
    public String ignoreCsrf(){
        return "csrf 적용 안함";
    }

    @PostMapping("/formCsrf")
    public CsrfToken formCsrf(CsrfToken csrfToken, String username, String password){
        return csrfToken;
    }

    @PostMapping("/cookieCsrf")
    public CsrfToken cookieCsrf(CsrfToken csrfToken){
        return csrfToken;
    }

    @GetMapping("/readCookie")
    public String readCookie(@CookieValue(value = "SESSION", defaultValue = "No Cookie") String cookieValue) {
        return "Cookie Value: " + cookieValue;
    }

    @PostMapping("/insertCookie")
    public String insertCookie(@CookieValue(value = "SESSION", defaultValue = "No Cookie") String cookieValue) {
        return "Cookie Value: " + cookieValue;
    }
}
