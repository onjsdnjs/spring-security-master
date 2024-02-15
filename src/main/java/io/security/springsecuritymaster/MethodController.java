package io.security.springsecuritymaster;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MethodController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    @Secured("ROLE_USER")
    public String user(){
        return "user";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String admin(){
        return "admin";
    }
    @GetMapping("/permitAll")
    @PermitAll
    public String permitAll(){
        return "permitAll";
    }
    @GetMapping("/denyAll")
    @DenyAll
    public String denyAll(){
        return "denyAll";
    }

    @GetMapping("/isAdmin")
    @isAdmin
    public String isAdmin(){
        return "isAdmin";
    }

    @GetMapping("/ownership")
    @OwnerShip
    public Account ownerShip(String name){
        return new Account(name, false);
    }
}
