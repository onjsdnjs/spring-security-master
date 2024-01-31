package io.security.springsecuritymaster.admin.service;

import org.springframework.context.annotation.Role;

import java.util.List;

public interface RoleService {
    Role getRole(long id);
    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}
