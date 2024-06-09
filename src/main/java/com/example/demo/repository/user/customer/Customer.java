package com.example.demo.repository.user.customer;

import com.example.demo.repository.sale.Sale;
import com.example.demo.repository.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
//@Table(name = "customers")
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Sale> sale;

}
