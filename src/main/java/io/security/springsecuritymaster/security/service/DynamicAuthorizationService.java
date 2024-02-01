package io.security.springsecuritymaster.security.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class DynamicAuthorizationService {
    private final LinkedHashMap<String, String> urlRoleMappings = new LinkedHashMap<>();
    public Map<String, String> getUrlRoleMappingsInMemory() {
            urlRoleMappings.put("/", "permitAll");
            urlRoleMappings.put("/signup", "permitAll");
            urlRoleMappings.put("/login", "permitAll");
            urlRoleMappings.put("/user", "ROLE_USER");
            urlRoleMappings.put("/admin", "ROLE_ADMIN");
            urlRoleMappings.put("/manager", "ROLE_MANAGER");
            urlRoleMappings.put("/db", "hasRole('ADMIN') or hasRole('MANAGER')");
            urlRoleMappings.put("/**", "authenticated");
            return new HashMap<>(urlRoleMappings);
    }
}
