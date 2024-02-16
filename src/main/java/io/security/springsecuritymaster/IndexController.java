package io.security.springsecuritymaster;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/user")
    public User user(){
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        return authentication == null ? null : (User)authentication.getPrincipal();
    }
    @GetMapping("/user2")
    public User user2(@AuthenticationPrincipal User user){
        return user;
    }
    @GetMapping("/user3")
    public User user3(@CurrentUser User user){
        return user;
    }
    @GetMapping("/username")
    public String username(@AuthenticationPrincipal(expression = "username") String username){
        return username;
    }
    @GetMapping("/username2")
    public String username2(@CurrentUserName String username){
        return username;
    }
    @GetMapping("/db")
    public String db(){
        return "db";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
