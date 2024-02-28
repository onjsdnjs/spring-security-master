package io.security.springsecuritymaster;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    public void securityContext(){
        SecurityContext securityContext = SecurityContextHolder.getContextHolderStrategy().getContext();
        Authentication authentication = securityContext.getAuthentication();
        System.out.println("authentication = " + authentication);
    }

}
