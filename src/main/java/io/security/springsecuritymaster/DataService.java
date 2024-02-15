package io.security.springsecuritymaster;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    public String getUser() {
        return "user";
    }
    public Account getOwner(String name) {
        return new Account(name, false);
    }
    public String display() {
        return "display";
    }
}
