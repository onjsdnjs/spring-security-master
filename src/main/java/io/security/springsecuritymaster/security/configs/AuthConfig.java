package io.security.springsecuritymaster.security.configs;

import io.security.springsecuritymaster.admin.service.RoleHierarchyService;
import io.security.springsecuritymaster.domain.entity.RoleHierarchy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public RoleHierarchyImpl roleHierarchy(RoleHierarchyService roleHierarchyService){

        String allHierarchy = roleHierarchyService.findAllHierarchy();
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(allHierarchy);

        return roleHierarchy;
    }

}
