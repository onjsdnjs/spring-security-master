package io.security.springsecuritymaster;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

import java.util.function.Supplier;

public class CustomAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    private static final String REQUIRED_ROLE = "ROLE_SECURE";
    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        Authentication auth = authentication.get();
        // 인증 정보가 없거나 인증되지 않은 경우
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return new AuthorizationDecision(false);
        }
        // "ROLE_SECURE" 권한을 가진 사용자인지 확인
        boolean hasRequiredRole = auth.getAuthorities().stream()
                .anyMatch(grantedAuthority -> REQUIRED_ROLE.equals(grantedAuthority.getAuthority()));

        return new AuthorizationDecision(hasRequiredRole);
    }
}
