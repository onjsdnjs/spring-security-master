package io.security.springsecuritymaster.security.service;

import io.security.springsecuritymaster.security.mapper.UrlRoleMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DynamicAuthorizationService {
    public Map<String, String> getUrlRoleMappings(UrlRoleMapper urlRoleMapper) {
            return urlRoleMapper.getUrlRoleMappings();
    }
}
