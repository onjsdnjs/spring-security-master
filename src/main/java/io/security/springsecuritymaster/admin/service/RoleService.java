package io.security.springsecuritymaster.admin.service;

import io.security.springsecuritymaster.domain.entity.Role;

import java.util.List;

public interface RoleService {
    Role getRole(long id);
    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}
