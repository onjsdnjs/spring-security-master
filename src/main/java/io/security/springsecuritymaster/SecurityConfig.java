package io.security.springsecuritymaster;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.io.IOException;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests( auth -> auth.anyRequest().authenticated())
                .rememberMe(rememberMe -> rememberMe
                .alwaysRemember(true)  // "기억하기" 매개변수가 설정되지 않았을 때에도 쿠키가 항상 생성되어야 함
                .tokenValiditySeconds(3600)  // 토큰이 유효한 시간(초 단위)
                .userDetailsService(userDetailsService)  // UserDetails를 조회하기 위해 사용되는 UserDetailsService 지정
                .rememberMeParameter("remember")  // 로그인 시 사용자를 기억하기 위해 사용되는 HTTP 매개변수
                .rememberMeCookieName("remember")  // 기억하기 인증을 위한 토큰을 저장하는 쿠키 이름
                .key("security")
                ;  // 기억하기 기능을 사용하기 위한 키

        return http.build();
    }

}
