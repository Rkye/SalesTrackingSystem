package com.example.demo.controller.authentication;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.TResponse;
import com.example.demo.controller.authentication.request.SignInRequest;
import com.example.demo.controller.authentication.request.SignUpRequest;
import com.example.demo.core.security.model.JwtToken;
import com.example.demo.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest request) {
        authenticationService.signUp(request);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/signin")
    ResponseEntity<TResponse<JwtToken>> signIn(@Valid @RequestBody SignInRequest request) {
        JwtToken response = authenticationService.signIn(request);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping("/isUserTrue")
    public ResponseEntity<TResponse<Boolean>> isCustomerTrue(
            @RequestParam String email, @RequestParam String password) {
        boolean response = authenticationService.isUserTrue(email, password);
        return answer(response, HttpStatus.OK);
    }

}
