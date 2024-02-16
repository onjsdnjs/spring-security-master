package io.security.springsecuritymaster;

import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AuthenticationEventPublisher authenticationEventPublisher;

    public CustomAuthenticationProvider(AuthenticationEventPublisher authenticationEventPublisher) {
        this.authenticationEventPublisher = authenticationEventPublisher;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authentication.getName().equals("admin")) {
            authenticationEventPublisher.publishAuthenticationFailure(new CustomException("CustomException"), authentication);

            throw new CustomException("CustomException");
        }else if(authentication.getName().equals("db")){
            authenticationEventPublisher.publishAuthenticationFailure(new DefaultAuthenticationException("DefaultAuthenticationException"), authentication);

            throw new DefaultAuthenticationException("DefaultAuthenticationException");
        }
        UserDetails user = User.withUsername("user").password("{noop}1111").roles("USER").build();
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
