package io.security.springsecuritymaster;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
