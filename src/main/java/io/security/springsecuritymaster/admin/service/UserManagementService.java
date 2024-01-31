package io.security.springsecuritymaster.admin.service;

import io.security.springsecuritymaster.domain.dto.AccountDto;
import io.security.springsecuritymaster.domain.entity.Account;

import java.util.List;

public interface UserManagementService {

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();
    AccountDto getUser(Long id);

    void deleteUser(Long idx);

}
