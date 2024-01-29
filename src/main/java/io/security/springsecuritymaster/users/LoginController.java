package io.security.springsecuritymaster.users;

import io.security.springsecuritymaster.domain.dto.AccountContext;
import io.security.springsecuritymaster.domain.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginController {
    @RequestMapping(value="/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model){
        model.addAttribute("error",error);
        model.addAttribute("exception",exception);
        return "login/login";
    }

    @RequestMapping(value="/rest/login")
    public String restLogin(){
        return "rest/login";
    }

    @GetMapping(value="/signup")
    public String signup() {
        return "login/signup";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "redirect:/login";
    }

    @GetMapping(value="/denied")
    public String accessDenied(@RequestParam(value = "exception", required = false) String exception, @AuthenticationPrincipal Account account, Model model) {

        model.addAttribute("username", account.getUsername());
        model.addAttribute("exception", exception);

        return "login/denied";
    }
}
