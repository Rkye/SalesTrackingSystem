package com.example.demo.repository.user.employee;

import com.example.demo.repository.user.User;
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
@SuperBuilder
//@Table(name = "employees")
public class Employee extends User {


}
