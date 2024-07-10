package com.example.demo.service.auth;

import com.example.demo.controller.authentication.request.SignInRequest;
import com.example.demo.controller.authentication.request.SignUpRequest;
import com.example.demo.core.security.model.JwtToken;

public interface AuthenticationService {

    void signUp(SignUpRequest request);

    JwtToken signIn(SignInRequest request);

    boolean isUserTrue(String email, String password);
}
