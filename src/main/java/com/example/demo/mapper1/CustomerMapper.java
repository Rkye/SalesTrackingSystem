package com.example.demo.mapper1;

import com.example.demo.controller.user.customer.request.CreateCustomerRequest;
import com.example.demo.controller.user.customer.response.CustomerResponse;
import com.example.demo.repository.user.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static Customer toEntity(CreateCustomerRequest request){
        if(request == null){
            return null;
        }

        return Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPhone())
                .build();
    }

    public static CustomerResponse toResponse(Customer customer){
        if(customer == null){
            return null;
        }

        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    public Customer toEntity(CustomerResponse response) {
        if (response == null) {
            return null;
        }
        return Customer.builder()
                .name(response.getName())
                .email(response.getEmail())
                .phone(response.getPhone())
                .build();
    }
}
