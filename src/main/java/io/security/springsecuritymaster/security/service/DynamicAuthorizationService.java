package io.security.springsecuritymaster.security.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DynamicAuthorizationService {
    private final Map<String, String> urlRoleMappings = new HashMap<>();
    public Map<String, String> getUrlRoleMappingsInMemory() {
            urlRoleMappings.put("/user", "ROLE_USER");
            urlRoleMappings.put("/admin", "ROLE_ADMIN");
            urlRoleMappings.put("/db", "hasRole('ADMIN') or hasRole('MANAGER')");
            urlRoleMappings.put("/**", "AUTHENTICATED");
            return new HashMap<>(urlRoleMappings);
    }
}
