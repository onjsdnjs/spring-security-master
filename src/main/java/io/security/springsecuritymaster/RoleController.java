package io.security.springsecuritymaster;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class RoleController {
    @GetMapping("/userRole")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user(){
        return "user";
    }

    @GetMapping("/adminRole")
    public String admin(){
        return "admin";
    }
}
