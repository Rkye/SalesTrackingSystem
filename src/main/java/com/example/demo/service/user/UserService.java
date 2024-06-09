package com.example.demo.service.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;

import java.util.List;

public interface UserService {

    void create(CreateUserRequest userRequest);

    void update(UpdateUserRequest userRequest);

    UserResponse getById(int id);

    List<UserResponse> getAll();

    void delete(int id);

}
