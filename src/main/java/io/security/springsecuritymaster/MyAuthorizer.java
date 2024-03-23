package io.security.springsecuritymaster;

import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.stereotype.Component;

@Component("myAuthorizer")
class MyAuthorizer {
    public boolean isUser(MethodSecurityExpressionOperations root) {
        boolean decision = root.hasAuthority("ROLE_USER");
        return decision;
    }
}
