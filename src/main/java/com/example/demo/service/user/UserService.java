package com.example.demo.service.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.repository.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserResponse getById(int id);

    List<UserResponse> getAll();

    void delete(int id);

    @Transactional
    User getByEmail(String emailAddress);

}
