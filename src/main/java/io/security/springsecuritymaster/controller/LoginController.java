package io.security.springsecuritymaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value="/login")
    public String manager() {
        return "login/login";
    }
}
