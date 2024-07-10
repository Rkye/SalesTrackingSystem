package com.example.demo.controller.authentication.request;

import com.example.demo.controller.user.customer.request.CreateCustomerRequest;
import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.service.user.model.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignUpRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

    @NotNull
    private RoleType roleType;

    public CreateCustomerRequest forCustomer() {
        return CreateCustomerRequest.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
    }

    public CreateEmployeeRequest forEmployee() {
        return CreateEmployeeRequest.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
    }

}
