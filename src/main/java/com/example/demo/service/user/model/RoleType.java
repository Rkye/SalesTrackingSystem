package com.example.demo.service.user.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum RoleType implements GrantedAuthority {

    USER("Kullanıcı"),

    ADMIN("Admin"),

    EMPLOYEE("Çalışan"),

    CUSTOMER("Müşteri");

    private final String label;

    RoleType(String label){
        this.label = label;
    }


    @Override
    public String getAuthority() {
        return name();
    }
}
