package io.security.springsecuritymaster.admin.repository;

import io.security.springsecuritymaster.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<Account, Long> { }
