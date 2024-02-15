package io.security.springsecuritymaster;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataService {
    @PreFilter("filterObject.owner == authentication.name")
    public List<Account> processData(List<Account> data) {

        return data;
    }
    @PreFilter("filterObject.value.owner == authentication.name")
    public Map<String, Account> processData2(Map<String, Account> data) {

        return data;
    }

    @PostFilter("filterObject.owner == authentication.name")
    public List<Account> readAccount() {
         return new ArrayList<>(List.of(
                 new Account("user",false),
                 new Account("db",false),
                 new Account("admin",false)
         ));
    }
    @PostFilter("filterObject.value.owner == authentication.name")
    public Map<String, Account> readAccount2() {
        return new HashMap<>(Map.of("user", new Account("user", false),
                "db", new Account("db", false),
                "admin", new Account("admin", false)));
    }
}
