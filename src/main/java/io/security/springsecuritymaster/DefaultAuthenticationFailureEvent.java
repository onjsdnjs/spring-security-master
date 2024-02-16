package io.security.springsecuritymaster;

import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class DefaultAuthenticationFailureEvent extends AbstractAuthenticationFailureEvent {

    public DefaultAuthenticationFailureEvent(Authentication authentication, AuthenticationException exception) {
        super(authentication, exception);
    }
}
