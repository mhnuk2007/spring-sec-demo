package com.learning.springsecdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
