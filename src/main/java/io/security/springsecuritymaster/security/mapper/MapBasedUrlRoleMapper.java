package io.security.springsecuritymaster.security.mapper;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MapBasedUrlRoleMapper implements UrlRoleMapper{
    @Override
    public Map<String, String> getUrlRoleMappings() {
        return null;
    }
}
