package com.example.demo.controller.user;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.TResponse;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<TResponse<UserResponse>> getById(@RequestParam int id){

        UserResponse response = userService.getById(id);
        return answer(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<TResponse<List<UserResponse>>> getAll(){

        List<UserResponse> responses = userService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam int id){

        userService.delete(id);
        return answer(HttpStatus.NO_CONTENT);

    }
}
