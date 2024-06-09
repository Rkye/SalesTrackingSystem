package com.example.demo.mapper1;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.repository.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(CreateUserRequest request){
        if(request == null){
            return null;
        }

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .build();
    }

    public static UserResponse toResponse(User user){
        if(user == null){
            return null;
        }

        return UserResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

}
