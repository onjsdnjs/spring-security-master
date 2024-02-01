package io.security.springsecuritymaster.security.service;

import io.security.springsecuritymaster.security.mapper.UrlRoleMapper;
import org.springframework.stereotype.Component;

import java.util.Map;
public class DynamicAuthorizationService {
    private final UrlRoleMapper delegate;
    public DynamicAuthorizationService(UrlRoleMapper delegate) {
        this.delegate = delegate;
    }
    public Map<String, String> getUrlRoleMappings() {
            return delegate.getUrlRoleMappings();
    }
}
