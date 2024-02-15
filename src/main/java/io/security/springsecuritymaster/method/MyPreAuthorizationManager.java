package io.security.springsecuritymaster.method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;

import java.util.function.Supplier;

public class MyPreAuthorizationManager implements AuthorizationManager<MethodInvocation> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, MethodInvocation invocation) {
        Authentication auth = authentication.get();
        if(auth instanceof AnonymousAuthenticationToken) new AuthorizationDecision(false);
        return new AuthorizationDecision(auth.isAuthenticated());
    }
}
