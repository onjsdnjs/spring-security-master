package io.security.springsecuritymaster.admin.repository;

import io.security.springsecuritymaster.domain.entity.RoleHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {
}
