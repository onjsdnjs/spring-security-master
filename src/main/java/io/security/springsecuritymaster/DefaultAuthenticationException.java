package io.security.springsecuritymaster;

import org.springframework.security.core.AuthenticationException;

public class DefaultAuthenticationException extends AuthenticationException {
    public DefaultAuthenticationException(String explanation) {
        super(explanation);
    }
}
