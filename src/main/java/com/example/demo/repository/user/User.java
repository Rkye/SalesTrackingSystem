package com.example.demo.repository.user;

import com.example.demo.core.Base;
import com.example.demo.service.user.model.RoleType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role_type")
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
