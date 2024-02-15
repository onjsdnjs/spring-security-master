package io.security.springsecuritymaster;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
    private String owner;
    private boolean isSecure;
}
