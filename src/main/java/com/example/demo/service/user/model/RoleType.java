package com.example.demo.service.user.model;

import lombok.Getter;

@Getter
public enum RoleType {

    USER("Kullanıcı"),

    ADMIN("Admin"),

    EMPLOYEE("Çalışan"),

    CUSTOMER("Müşteri");

    private final String label;

    RoleType(String label){
        this.label = label;
    }


}
