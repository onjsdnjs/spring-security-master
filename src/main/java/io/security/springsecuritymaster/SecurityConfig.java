package io.security.springsecuritymaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                    .logoutUrl("/logoutProc") // 로그아웃이 발생하는 URL 지정
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logoutProc")) // 로그아웃 RequestMatcher 지정, logoutUrl 보다 우선적
                    .logoutSuccessUrl("/logoutSuccess") // 로그아웃 성공 후 리다이렉션 될 URL
                    .logoutSuccessHandler((request, response, authentication) -> {
                        response.sendRedirect("/logoutSuccess"); // 로그아웃 성공 핸들러
                    })
                    .deleteCookies("JSESSIONID", "CUSTOM_COOKIE") // 로그아웃 성공 시 제거될 쿠키 지정
                    .invalidateHttpSession(true) // HttpSession 무효화
                    .clearAuthentication(true) // 로그아웃 시 인증 정보 삭제
                    .addLogoutHandler((request, response, authentication) -> {
                        // 새로운 LogoutHandler 추가할 수 있음
                    })
                    .permitAll()); // 로그아웃 URL에 대한 모든 사용자 접근 허용
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user").password("{noop}1111").roles("USER").build();
        return  new InMemoryUserDetailsManager(user);
    }
}
