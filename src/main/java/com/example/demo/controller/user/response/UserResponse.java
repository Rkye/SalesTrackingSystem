package com.example.demo.controller.user.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String name;

    private String email;

    private String phone;

}
