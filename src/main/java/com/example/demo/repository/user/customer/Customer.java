package com.example.demo.repository.user.customer;

import com.example.demo.repository.sale.Sale;
import com.example.demo.repository.user.User;
import com.example.demo.service.user.model.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Sale> sale;

    @Override
    protected void beforeCreate() {
        super.beforeCreate();
        setRoleType(RoleType.CUSTOMER);
    }

    @Override
    protected void beforeUpdate() {
        super.beforeUpdate();
        setRoleType(RoleType.CUSTOMER);
    }

}
