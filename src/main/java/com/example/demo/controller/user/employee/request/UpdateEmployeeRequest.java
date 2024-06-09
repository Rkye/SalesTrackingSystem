package com.example.demo.controller.user.employee.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateEmployeeRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

}
