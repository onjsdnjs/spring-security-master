package io.security.springsecuritymaster;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getUser() {
        return "user";
    }
    @PostAuthorize("returnObject.owner == authentication.name")
    public Account getOwner(String name) {
        return new Account(name, false);
    }
}
