package com.example.storeApi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "custom.security")
@Data
public class CustomSecurityProperties {
    private List<User> users;

    @Data
    public static class User {
        private String username;
        private String password;
        private String roles;
    }
}
