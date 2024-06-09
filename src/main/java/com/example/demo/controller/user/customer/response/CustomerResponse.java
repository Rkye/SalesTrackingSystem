package com.example.demo.controller.user.customer.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private String name;

    private String email;

    private String phone;

}
