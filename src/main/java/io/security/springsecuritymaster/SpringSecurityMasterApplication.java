package io.security.springsecuritymaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringSecurityMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityMasterApplication.class, args);
    }

}
