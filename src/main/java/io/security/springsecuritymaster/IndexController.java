package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final SecurityContextService securityContextService;
    @GetMapping("/")
    public String index(){
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        Authentication authentication = securityContext.getAuthentication();
        System.out.println("authentication = " + authentication);

        securityContextService.securityContext();

        return "index";

    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(@CurrentSecurityContext SecurityContext context){
        return "logoutSuccess";
    }
}
