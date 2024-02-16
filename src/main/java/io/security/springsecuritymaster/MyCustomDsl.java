package io.security.springsecuritymaster;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl, HttpSecurity> {
    private boolean flag;
    @Override
    public void init(HttpSecurity http) throws Exception {
        super.init(http);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        MyAuthFilter myAuthFilter = new MyAuthFilter();
        myAuthFilter.setFlag(flag);
        http.addFilterBefore(myAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }
    public MyCustomDsl flag(boolean value) {
        this.flag = value;
        return this;
    }
    public static MyCustomDsl customDsl() {
        return new MyCustomDsl();
    }
}
