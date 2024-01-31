package io.security.springsecuritymaster.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLoginController {
    @PostMapping(value="/api/login")
    public String restLogin(){
        return "restLogin";
    }
}
