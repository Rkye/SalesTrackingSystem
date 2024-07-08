package com.example.demo.controller.user.response;

import com.example.demo.service.user.model.RoleType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String name;

    private String surname;

    private String email;

    private String phone;

    private RoleType roleType;

    public String getRoleTypeLabel() {
        return roleType != null ? roleType.getLabel() : null;
    }

}
