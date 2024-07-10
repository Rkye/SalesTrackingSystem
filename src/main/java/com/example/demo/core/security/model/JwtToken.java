package com.example.demo.core.security.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtToken {

    private String token;

}
