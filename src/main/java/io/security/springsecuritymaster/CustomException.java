package io.security.springsecuritymaster;

import org.springframework.security.core.AuthenticationException;

public class CustomException extends AuthenticationException {
    public CustomException(String explanation) {
        super(explanation);
    }
}
