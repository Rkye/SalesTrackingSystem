package com.example.demo.service.auth;

import com.example.demo.controller.authentication.request.SignInRequest;
import com.example.demo.controller.authentication.request.SignUpRequest;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.security.JwtService;
import com.example.demo.core.security.model.JwtToken;
import com.example.demo.repository.user.User;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.customer.CustomerService;
import com.example.demo.service.user.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.demo.core.exception.type.NotFoundExceptionType.USER_ROLE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationService{


    private final EmployeeService employeeService;
    private final CustomerService customerService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public void signUp(SignUpRequest request) {

        switch (request.getRoleType()) {
            case EMPLOYEE -> this.employeeService.create(request.forEmployee());
            case CUSTOMER -> {
                this.customerService.create(request.forCustomer());
            }
            default -> throw new NotFoundException(USER_ROLE_NOT_FOUND);
        }

    }

    @Transactional
    public JwtToken signIn(SignInRequest request) {
        User user = userService.getByEmail(request.getEmail());

        if (isUserTrue(request.getEmail(), request.getPassword())) {
            String token = jwtService.generateToken(user);
            return JwtToken.builder().token(token).build();
        }
        throw new RuntimeException("Bilgiler hatalı");
    }

    @Override
    public boolean isUserTrue(String emailAddress, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(emailAddress, password)
        );
        return authentication.isAuthenticated();
    }
}
