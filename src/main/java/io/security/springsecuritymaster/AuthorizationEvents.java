package io.security.springsecuritymaster;

import org.springframework.context.event.EventListener;
import org.springframework.security.authorization.event.AuthorizationDeniedEvent;
import org.springframework.security.authorization.event.AuthorizationEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationEvents {

    @EventListener
    public void onAuthorization(AuthorizationEvent event){
        System.out.println("failure = " + event.getAuthentication().get().getAuthorities());
    }
    @EventListener
    public void onFailure(AuthorizationDeniedEvent failure){
        System.out.println("failure = " + failure.getAuthentication().get().getAuthorities());
    }
}