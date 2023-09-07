package com.likelion.springsecuritysession.domain;

import lombok.Getter;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    SESSION_USER("ROLE_USER"),

    JWT_User("ROLE_JWT");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}
