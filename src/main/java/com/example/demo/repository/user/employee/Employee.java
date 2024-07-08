package com.example.demo.repository.user.employee;

import com.example.demo.repository.user.User;
import com.example.demo.service.user.model.RoleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends User {

    @Override
    protected void beforeCreate() {
        super.beforeCreate();
        setRoleType(RoleType.EMPLOYEE);
    }

    @Override
    protected void beforeUpdate() {
        super.beforeUpdate();
        setRoleType(RoleType.EMPLOYEE);
    }

}
