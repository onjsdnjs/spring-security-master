package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final ApplicationContext applicationEventPublisher;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(!authentication.getName().equals("user")) {
            applicationEventPublisher.publishEvent
                    (new AuthenticationFailureDisabledEvent(authentication, new DisabledException("DisabledException")));

            applicationEventPublisher.publishEvent
                    (new AuthenticationFailureBadCredentialsEvent(authentication, new BadCredentialsException("BadCredentialException")));
        }
        UserDetails user = User.withUsername("user").password("{noop}1111").roles("USER").build();
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
