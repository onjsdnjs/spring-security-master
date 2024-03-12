package io.security.springsecuritymaster.method;

import io.security.springsecuritymaster.Account;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.method.MethodInvocationResult;
import org.springframework.security.core.Authentication;

import java.util.function.Supplier;

public class MyPostAuthorizationManager implements AuthorizationManager<MethodInvocationResult> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, MethodInvocationResult result) {
        Authentication auth = authentication.get();
        if(auth instanceof AnonymousAuthenticationToken) return new AuthorizationDecision(false);
        Account account = (Account) result.getResult();
        boolean isGranted = account.getOwner().equals(authentication.get().getName());
        return new AuthorizationDecision(isGranted);
    }
}
