package io.security.springsecuritymaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user").hasAuthority("USER") // "/user" 엔드포인트에 대해 "USER" 권한을 요구합니다.
                .requestMatchers("/mypage/**").hasAuthority("USER") // "/mypage" 및 하위 디렉터리에 대해 "USER" 권한을 요구합니다. Ant 패턴 사용.
                .requestMatchers(new RegexRequestMatcher("/resource/[A-Za-z0-9]+", null)).hasAuthority("USER") // 정규 표현식을 사용하여 "/resource/[A-Za-z0-9]+" 패턴에 "USER" 권한을 요구합니다.
                .requestMatchers(HttpMethod.GET, "/**").hasAuthority("read") // GET 메소드를 사용하는 모든 요청에 대해 "read" 권한을 요구합니다.
                .requestMatchers(HttpMethod.POST).hasAuthority("write") // POST 메소드를 사용하는 모든 요청에 대해 "write" 권한을 요구합니다.
                .requestMatchers(new AntPathRequestMatcher("/manager/**")).hasAuthority("MANAGER") // "/manager" 및 하위 디렉터리에 대해 "MANAGER" 권한을 요구합니다. AntPathRequestMatcher 사용.
                .requestMatchers("/admin/**").hasAnyAuthority("ADMIN", "MANAGER") // "/admin" 및 하위 디렉터리에 대해 "ADMIN" 또는 "MANAGER" 권한 중 하나를 요구합니다.
                .anyRequest().authenticated())// 위에서 정의한 규칙 외의 모든 요청은 인증을 필요로 합니다.
                .formLogin(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user").password("{noop}1111").roles("USER").build();
        UserDetails manager = User.withUsername("user").password("{noop}1111").roles("USER").build();
        UserDetails admin = User.withUsername("user").password("{noop}1111").roles("USER").build();
        return  new InMemoryUserDetailsManager(user, manager, admin);
    }
}
