package com.example.demo.controller.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public void create(CreateUserRequest userRequest){

        userService.create(userRequest);

    }

    @PutMapping
    public void update(UpdateUserRequest userRequest){

        userService.update(userRequest);

    }

    @GetMapping("/{id}")
    public UserResponse getById(@RequestParam int id){

        return userService.getById(id);

    }

    @GetMapping
    public List<UserResponse> getAll(){

        return userService.getAll();

    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam int id){

        userService.delete(id);

    }
}
